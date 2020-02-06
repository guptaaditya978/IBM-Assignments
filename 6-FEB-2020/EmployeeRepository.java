import java.util.*;


class Employee{
	int empId;
	
	Employee(int id){
		this.empId = id;
	}

	public int getEmpId(){
		return this.empId;
	}
}

class EmployeeRepository{
	public static void main(String[] args) {
		ArrayList empList = new ArrayList(); 
		Employee e1 = new Employee(10001);
		Employee e2 = new Employee(10002);
		Employee e3 = new Employee(10003);
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		ArrayList<Computer> cmpList = new ArrayList<Computer>();

		Scanner sc = new Scanner(System.in);		
		int cmpid = 101;

		while(true){
			System.out.println("Hello!! Please Select an option to continue :");
			System.out.println("1. Add A New Computer");
			System.out.println("2. Display All Computers");
			System.out.println("3. Search For A Computer");
			System.out.println("4. Delete A Computer By ID");
			System.out.println("5. Update Computer Details");
			System.out.println("6. Exit The System");
			int n = sc.nextInt();
			
			if(n == 1){
				System.out.println("Please Enter Your Employee Id to Verify Yourself.");
				int emp = sc.nextInt();
				boolean flag = false;
				for(Object e : empList){
					if(((Employee) e ).getEmpId() == emp){
						flag = true;
						break;
					}
				}
				if(!flag){
					System.out.println("You are not a verified employee. You have been re-directed to the previous menu");
				}
				else{
					System.out.println("Wow you got verified");
					String cmpname,cmpcolor;
					int cmphdd,cmpram;
					System.out.println("Please Enter the computer name");
					cmpname = sc.next();
					System.out.println("Please Enter the computer color");
					cmpcolor = sc.next();
					System.out.println("Please Enter the computer hard disk size");
					cmphdd = sc.nextInt();
					System.out.println("Please Enter the computer ram size");
					cmpram = sc.nextInt();

					Computer c1 = new Computer(cmpid, cmpname, cmpcolor, cmphdd, cmpram);
					cmpList.add(c1);
					cmpid++;
					System.out.println("Computer Added Succcessfully");
					try{
						System.out.println("You have been re-directed to previous menu");
						Thread.sleep(5000);
					}catch(Exception e){
						System.out.println("caught");
					}						
				}
			}
			else if (n == 2){
				if(cmpList.size()!=0){
					System.out.println("Here is the list of all the computers.");
				for(Computer c : cmpList){
					System.out.println(c);
				}	
				}
				else{
					System.out.println("No computers are present ");
				}
				try{
						System.out.println("You have been re-directed to previous menu");
						Thread.sleep(5000);
					}catch(Exception e){
						System.out.println("caught");
					}	
			}
			else if (n == 3){
				System.out.println("PLease select the option by which you want to search the computer");
				System.out.println("1. By ID");
				System.out.println("2. By NAME");
				System.out.println("3. By COLOR");
				System.out.println("4. By HDDSIZE");
				System.out.println("5. By RAMSIZE");

				int opt = sc.nextInt();

				if(opt == 1){
					System.out.println("PLease Enter the Id");
					int tempId = sc.nextInt();
					// Computer c;
					for(int i=0;i<cmpList.size();i++){
						if(cmpList.get(i).getId() == tempId){
							System.out.println(cmpList.get(i));
						}
					}
				}
				else if(opt == 2){
					System.out.println("PLease Enter the Name");
					String tempName = sc.next();
					// Computer c;
					for(int i=0;i<cmpList.size();i++){
						if(cmpList.get(i).getName().compareTo(tempName)==0){
							System.out.println(cmpList.get(i));
						}
					}
				}
				else if(opt == 3){
					System.out.println("PLease Enter the Color");
					String tempColor = sc.next();
					// Computer c;
					for(int i=0;i<cmpList.size();i++){
						if(cmpList.get(i).getColor().compareTo(tempColor)==0){
							System.out.println(cmpList.get(i));
						}
					}
				}
				else if(opt == 4){
					System.out.println("PLease Enter the hard disk size");
					int tempHdd = sc.nextInt();
					// Computer c;
					for(int i=0;i<cmpList.size();i++){
						if(cmpList.get(i).getHddSize() == tempHdd){
							System.out.println(cmpList.get(i));
						}
					}

				}
				else if(opt == 5){
					System.out.println("PLease Enter the ram size");
					int tempRam = sc.nextInt();
					// Computer c;
					for(int i=0;i<cmpList.size();i++){
						if(cmpList.get(i).getRamSize() == tempRam){
							System.out.println(cmpList.get(i));
						}
					}
				}
				else{
					System.out.println("Invalid Input");
					try{
						System.out.println("You have been re-directed to previous menu");
						Thread.sleep(5000);
					}catch(Exception e){
						System.out.println("caught");
					}

				}	
			}
			else if(n == 4){
				System.out.println("Please Enter Your Employee Id to Verify Yourself.");
				int emps = sc.nextInt();
				boolean flagdel = false;
				for(Object e : empList){
					if(((Employee) e ).getEmpId() == emps){
						flagdel = true;
						break;
					}
				}
				if(!flagdel){
					System.out.println("You are not a verified employee. You have been re-directed to the previous menu");
				}
				else{
					System.out.println("Enter the ID of the computer you want to Delete");
					int tempId = sc.nextInt();
					// Computer c;
					boolean flag1=false;
					int i1=0;
					for(i1=0;i1<cmpList.size();i1++){
						if(cmpList.get(i1).getId() == tempId){
							flag1=true;
							break;
						}
					}
					if(flag1){
						cmpList.remove(i1);
						System.out.println("Deleted Succcessfully");
					}
					else{
						System.out.println("Could Not find the computer with associated ID");
					}
				}
				try{
						System.out.println("You have been re-directed to previous menu");
						Thread.sleep(3000);
					}catch(Exception e){
						System.out.println("caught");
					}
			}
			else if(n == 5){
				System.out.println("Please Enter Your Employee Id to Verify Yourself.");
				int emps1 = sc.nextInt();
				boolean flagupdt = false;
				for(Object e : empList){
					if(((Employee) e ).getEmpId() == emps1){
						flagupdt = true;
						break;
					}
				}
				if(!flagupdt){
					System.out.println("You are not a verified employee. You have been re-directed to the previous menu");
				}
				else{
					System.out.println("Enter the ID of the computer you want to Update");
				int tempId = sc.nextInt();
					// Computer c;
					int i2=0;
					boolean flag2=false;
					for( i2=0;i2<cmpList.size();i2++){
						if(cmpList.get(i2).getId() == tempId){
							flag2=true;
							break;
						}
					}
					if(flag2){
						while(true){
							System.out.println("Please Select an optoin you want to update");
							System.out.println("1.Update Name");
							System.out.println("2.Update Color");
							System.out.println("3.Update hard disk size");
							System.out.println("4.Update ram size");
							System.out.println("5. Go back to previous menu");
							int upoption = sc.nextInt();
							if(upoption == 1){
								System.out.println("Please Enter the computer name");
								cmpList.get(i2).setName(sc.next());	
								System.out.println("Updated Succcessfully");
							}
							else if(upoption == 2){
								System.out.println("Please Enter the computer color");
								cmpList.get(i2).setColor(sc.next());
								System.out.println("Updated Succcessfully");
							}
							else if(upoption ==3){
								System.out.println("Please Enter the computer hard disk size");
								cmpList.get(i2).setHddSize(sc.nextInt());
								System.out.println("Updated Succcessfully");
							}
							else if(upoption ==4){
								System.out.println("Please Enter the computer ram size");
								cmpList.get(i2).setRamSize(sc.nextInt());	
								System.out.println("Updated Succcessfully");
							}
							else{
								break;
							}
						}				
					}
					else{
						System.out.println("Could Not find the computer with associated ID");
					}
				}
				try{
						System.out.println("You have been re-directed to previous menu");
						Thread.sleep(3000);
					}catch(Exception e){
						System.out.println("caught");
					}
				
			}
			else if(n == 6){
				System.out.println("Thank you");
				break;
			}
			else{
				System.out.println("PLease try to giva a valid input");
			}
		}
	}
}
class Computer{
	private String name,color;
	private int id,hddSize,ramSize;
	Computer(int id,String name,String color,int hddSize,int ramSize){
		this.id = id;
		this.name = name;
		this.color = color;
		this.hddSize = hddSize;
		this.ramSize = ramSize;
	}

	public void setId(int i){
		this.id = i;
	}
	public void setName(String n){
		this.name = n;
	}
	public void setColor(String c){
		this.color = c;
	}
	public void setHddSize(int h){
		this.hddSize = h;
	}
	public void setRamSize(int r){
		this.ramSize = r;
	}
	
	public int getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getColor(){
		return this.color;
	}
	public int getHddSize(){
		return this.hddSize;
	}
	public int getRamSize(){
		return this.ramSize;
	}

	@Override
	public String toString(){
		return "[ "+this.getId()+", "+this.getName()+", "+this.getColor()+", "+this.getHddSize()+", "+this.getRamSize()+" ]";
	}
}