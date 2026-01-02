package com.raj.runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.JobSeeker;
import com.raj.service.IJobSeekerMgmtService;

@Component
public class LOBsInsertionTestRunner implements CommandLineRunner {

	@Autowired
	private IJobSeekerMgmtService jsService;
	
	@Override
	public void run(String... args) throws Exception {
		
		try(Scanner sc = new Scanner(System.in)){
			
			while(true) {
				System.out.println("======== Job Seeker Management System ==========");
				System.out.println("1. Register new Job Seeker.");
				System.out.println("2. Find Job Seeker By ID.");
				System.out.println("3. Show All Job Seekers.");
				System.out.println("4. Exit.");
				
				System.out.print("Enter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				case 1: 
					System.out.print("Enter JS Name: ");
					String name = sc.nextLine();
					
					System.out.print("Enter JS Address: ");
					String addrs = sc.nextLine();
					
					System.out.print("Enter JS Photo Path: ");
					String photoPath = sc.nextLine().trim();
					
					System.out.print("Enter JS Resume Path: ");
					String resumePath = sc.nextLine().trim();
					
					byte[] photoContent = null;
					char[] resumeContent = null;
					
					try(FileInputStream fis = new FileInputStream(photoPath);
						FileReader reader = new FileReader(resumePath);){
						
						//convert photo file content to byte[]
						photoContent= fis.readAllBytes();
						
						//convert resume file content  to char[]
						File file = new File(resumePath);
						resumeContent = new char[(int)file.length()];
						
						reader.read(resumeContent);
						
					}catch (Exception e) {
						
						e.printStackTrace();
					}
					//create Entity Object
					JobSeeker jobSeeker = new JobSeeker(name, addrs, photoContent, resumeContent);
					String registerJobSeeker = jsService.registerJobSeeker(jobSeeker);
					System.out.println(registerJobSeeker);
					break;
				case 2:
					try(FileOutputStream fos = new FileOutputStream("retrive_photo.jpg");
							FileWriter writer = new FileWriter("retrive_resume.txt")){
						
						System.out.print("Enter ID:");
						int id = Integer.parseInt(sc.nextLine());
						
						JobSeeker jsById = jsService.findJobSeekerById(id);
						System.out.println("Job Seeker details are :: ID:"+jsById.getJsid()+" Name: "+jsById.getJsname()+" Address: "+jsById.getJsaddrs());
						//retrive LOB values from entity object and write dest file
						
						photoContent = jsById.getPhoto();
						resumeContent = jsById.getResume();
						
						fos.write(photoContent);
						writer.write(resumeContent);
						
					}catch (Exception e) {
						
						e.printStackTrace();
					}
					System.out.println("LOBs are retrived...");
					break;
				case 3:
					break;
				case 4:
					System.exit(0);
				}
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}

	}
}
