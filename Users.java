import java.util.*;
public class Users {
    static Map<Integer,Users> User = new HashMap<>();
    static Map<Integer,Users> Admin = new HashMap<>();
    String [] cities ={"CHENNAI","BANGALORE","DELHI","KOCHIN","SHANGHAI","MUMBAI","PUNE","GOA","PONDICHERRY","TAMPA"};
    String [] services ={"VEHICLE WASHING"};
    static ArrayList<String> RecentCities = new ArrayList<>();
    static ArrayList<String> RecentServices = new ArrayList<>();
    static Map<Integer,Users> Booking_details = new HashMap<>();
    static ArrayList<Integer> APPROVEDLIST = new ArrayList<>();
    static ArrayList<Integer> REJECTEDLIST = new ArrayList<>();
    String name;
    String phone;
    String email;
    String password;
    String service;
    static int Id = 1;
    int user_id ;
    String date ="";
    String place="";
      int refnumber=1  ;

    public Users(){
        this.name = "";
        this.phone = "";
        this.user_id = Id;
        this.email= "";
        this.password=" ";
    }

    public  Users(String name, String phone,String email,String passwords){
        this.name = name;
        this.phone = phone;
        this.user_id = Id++;
        this.email = email;
        this.password = passwords;
    }

    public  Users(Integer user_id ,String name, String phone,String email,String place,String date,String service){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.date=date;
        this.place=place;
        this.user_id =user_id;
        this.service = service;
        if(Booking_details.size()!=0){
            this.refnumber = Booking_details.size()+1;
        }
        else{
            this.refnumber = 1;
        }
    }

    public void Start(){
        Scanner sc = new Scanner(System.in);
        System.out.println("*************  WELCOME TO VEMS CAR WASH  *************");
        System.out.println("1.SIGN UP"+"    "+ "2.SIGN IN"+"    "+ "3.CLOSE THE SITE");
        System.out.println("PLEASE ENTER THE NUMBER WITH RESPECT TO THE CHOICES GIVEN");
        int temp =sc.nextInt();
        switch (temp){
            case 1:
                System.out.println("SELECT FROM THE ROLES GIVEN BELOW");
                System.out.println("1.USER"+"  "+"2.ADMIN");
                int option = sc.nextInt();
                if(option==1){
                    Users a = new Users();
                    a.Signup_details(option);
                    break;
                }
                else if(option==2){
                    System.out.println("FOR DIRECT ADMIN SIGN UP YOU HAVE TO ENTER SECURITY CODE");
                    String securitycodecirtics = sc.next();
                    String securitycode="ADMIN";
                    if(securitycodecirtics.equals(securitycode)){
                        System.out.println("ACCESS GRANTED");
                        Users a = new Users();
                        a.Signup_details(option);
                        break;
                    }
                    else{
                        System.out.println("Security code mismatch");
                        Start();
                        break;
                    }
                }
                else{
                    System.out.println("ENTER CORRECT NUMERICAL VALUES ONLY");
                    Start();
                    break;
                }
            case 2:
                int check=0;
                try{
                    System.out.println("1.USER"+"  "+"2.ADMIN");
                    option = sc.nextInt();
                    if(option==1){
                        check =0;
                        System.out.println("ENTER YOUR USER_ID");
                        int USER_IDs = sc.nextInt();
                        System.out.println("ENTER THE PASSWORD");
                        String password =sc.next();
                        if(User.isEmpty()){
                            System.out.println("NO USERS IN DATABASE");
                            Start();
                            break;
                        }
                        for(Users m: User.values()){
                            if(USER_IDs==m.user_id) {
                                check =1;
                                if (password.equals(m.password)) {
                                    System.out.println("SUCCESSFULLY LOGGED IN ");
                                    Booking_system(m, option);
                                    break;
                                }
                                else {
                                    System.out.println("PASSWORD MISMATCH PLEASE ENTER CORRECT PASSWORD");
                                    Start();
                                    break;
                                }
                            }
                        }
                        if(check!=1){
                            System.out.println("USER ID NOT FOUND");
                            Start();
                            break;
                        }
                    }
                    if(option==2){
                        check =0;
                        System.out.println("ENTER YOUR USER_ID");
                        int USER_IDs = sc.nextInt();
                        System.out.println("ENTER THE PASSWORD");
                        String password =sc.next();
                        if(Admin.isEmpty()){
                            System.out.println("NO ADMIN IN DATABASE");
                            Start();
                            break;
                        }
                        for(Users m: User.values()){
                            if(USER_IDs==m.user_id) {
                                check =1;
                                if (password.equals(m.password)) {
                                    System.out.println("SUCCESSFULLY LOGGED IN ");
                                    Booking_system(m,option);
                                    break;
                                }
                                else {
                                    System.out.println("PASSWORD MISMATCH PLEASE ENTER CORRECT PASSWORD");
                                    Start();
                                    break;
                                }
                            }
                        }
                        if(check!=1){
                            System.out.println("USER ID NOT FOUND");
                            Start();
                            break;
                        }
                    }
                }
                catch(Exception e){
                    System.out.println("ENTER NUMERIC VALUES ONLY");
                    Start();
                    break;
                }
            case 3:
                System.out.println("             THANKS FOR VISITING VEMS CAR WASH PVT.LTD");
                System.out.println("                    HAVE A GOOD DAY ");
                break;
        }
    }
    public void Signup_details(int options) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE DETAILS");
        System.out.println("ENTER YOUR NAME");
        String name = sc.nextLine();
        if (name.isEmpty()) {
            System.out.println("ENTER A VALID NAME");
            Signup_details(options);
        }
        System.out.println("ENTER YOUR PHONE NUMBER");
        String phone = sc.next();
        while (phone.length() != 10) {
            System.out.println("ENTER A VALID NUMBER");
            System.out.println("ENTER YOUR PHONE NUMBER");
            phone = sc.next();
        }
        System.out.println("ENTER YOUR EMAIL ID");
        String email = sc.next();
        System.out.println("ENTER THE PASSWORD");
        System.out.println("PASSWORD CAN CONTAIN NUMERICS,ALPHABETS,ETC." + '\n' + "IT'S LENGTH MUST BE GREATER THAN 8 CHARACTERS");
        String password = sc.next();
        if (password.length() < 8) {
            System.out.println("PASSWORD IS TOO SHORT");
            System.out.println("ENTER THE PASSWORD");
            password = sc.next();
        }
        System.out.println("RE-ENTER PASSWORD FOR COMFORMATION");
        String confirmpassword = sc.next();
        while (!password.equals(confirmpassword)) {
            System.out.println("PASSWORD MISMATCH TRY AGAIN");
            System.out.println("ENTER THE PASSWORD");
            password = sc.next();
            System.out.println("RE-ENTER PASSWORD FOR COMFORMATION");
            confirmpassword = sc.next();
        }
        Users a = new Users(name, phone, email, password);
        if(options==2){
           Add_admin(a);
            Admin_privilege(a);
        }
        Add_user(a);
        Booking_system(a,options);
    }
    public void Add_user(Users a){
        User.put(a.user_id,a);
    }
    public void Add_admin(Users a){
        User.put(a.user_id,a);
    }

    public void Admin_privilege(Users a)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.ADD PLACES 2.ADD SERVICES 3.VIEW ALL BOOKING AND FILTER 4.ACCEPT/REJECT BOOKING 5.EXIT");
        int option=sc.nextInt();
        switch(option){
            case 1:
                System.out.println("NAME OF NEW WORKSHOP PLACE");
                String newplaces =sc.next().toUpperCase();
                Add_city(newplaces);
                System.out.println("NEW PLACE ADDED SUCCESSFULLY");
                Admin_privilege(a);
                break;
            case 2:
                System.out.println("ADDITION OF NEW SERVICES");
                String service =sc.next().toUpperCase();
                Add_Service(service);
                System.out.println("NEW SERVICE ADDED SUCCESSFULLY");
                Admin_privilege(a);
                break;
            case 3:
                if(Booking_details.isEmpty()){
                    System.out.println("NO BOOKING HAVE BEEN MADE IN THE SITE");
                    Admin_privilege(a);
                    break;
                }
                int p=0;
                System.out.println("USER_ID"+" "+"NAME"+" "+"PHONE"+" "+"EMAIL"+" "+"PLACE"+" "+"DATE"+" "+"SERVICE");
                for(Users m : Booking_details.values()){
                        if (p == 0) {
                            System.out.print("");
                            p=1;
                        }
                        else{
                    System.out.println(m.user_id+" "+m.name+" "+m.phone+" "+m.email+" "+m.place+" "+m.date+" "+m.service);
                }}
                System.out.println("FILTER WITH RESPECT TO 1.PLACES 2.DATE");
                int opt=sc.nextInt();
                int f=0;
                 p=0;
                if(opt==1){
                    System.out.println("ENTER PLACE NAME IN CAPITAL LETTERS");
                    String word =sc.next().toUpperCase();
                    System.out.println("USER_ID"+" "+"NAME"+" "+"PHONE"+" "+"EMAIL"+" "+"PLACE"+" "+"DATE"+" "+"SERVICE");
                    for(Users m: Booking_details.values()){
                        if (p == 0) {
                            System.out.print("");
                            p=1;
                        }
                        else{
                        if(word.equals(m.place)){
                            f=1;
                            System.out.println(m.user_id+" "+m.name+" "+m.phone+" "+m.email+" "+m.place+" "+m.date+" "+m.service);
                        }
                      }
                    }
                    if(f!=1){
                        System.out.println("NO PLACES FOUND IN DATABASE");
                    }
                    Admin_privilege(a);
                    break;
                 }
                p=0;
                if(opt==2){
                    System.out.println("ENTER DATE CORRECTLY");
                    String word =sc.next();
                    System.out.println("USER_ID"+" "+"NAME"+" "+"PHONE"+" "+"EMAIL"+" "+"PLACE"+" "+"DATE"+" "+"SERVICE");
                    for(Users m: Booking_details.values()){
                        if (p == 0) {
                            System.out.print("");
                            p=1;
                        }
                        else{
                            if(word.equals(m.date)){
                            f=1;
                            System.out.println(m.user_id+" "+m.name+" "+m.phone+" "+m.email+" "+m.place+" "+m.date+" "+m.service);
                           }
                       }
                    }
                    if(f!=1){
                        System.out.println("NO RECORD FOUND WITH THIS DATE IN DATABASE");
                    }
                    Admin_privilege(a);
                    break;
                 }
                else{
                    System.out.println("enter correct value");
                Admin_privilege(a);
                break;
                }
            case 4:
                if(Booking_details.isEmpty()){
                    System.out.println("NO BOOKING HAVE BEEN MADE IN THE SITE");
                    Admin_privilege(a);
                    break;
                }
                System.out.println("1.APPROVE  2.REJECT");
                int num =sc.nextInt();
                if(num==1){
                System.out.println("USER_ID"+" "+"NAME"+" "+"PHONE"+" "+"EMAIL"+" "+"PLACE"+" "+"DATE"+" "+"SERVICE");
                for(Users m : Booking_details.values()){
                    System.out.println(m.user_id+" "+m.name+" "+m.phone+" "+m.email+" "+m.place+" "+m.date+" "+m.service);
                }
                System.out.println("SELECT THE ID TO ACCEPT THE BOOKING");
                int id = sc.nextInt();
                APPROVEDLIST.add(id);
                Booking_details.remove(id);
                Admin_privilege(a);
                break;
                }
                else if(num==2){
                    System.out.println("USER_ID"+" "+"NAME"+" "+"PHONE"+" "+"EMAIL"+" "+"PLACE"+" "+"DATE"+" "+"SERVICE");
                    for(Users m : Booking_details.values()){
                        System.out.println(m.user_id+" "+m.name+" "+m.phone+" "+m.email+" "+m.place+" "+m.date+" "+m.service);
                    }
                    System.out.println("SELECT THE ID TO REJECT THE BOOKING");
                    int id = sc.nextInt();
                    REJECTEDLIST.add(id);
                    Booking_details.remove(id);
                    Admin_privilege(a);
                    break;
                }
            case 5:
                Start();
                break;
                }
    }
    public void Add_city(String place){
        RecentCities.add(place);
    }
    public void Add_Service(String place){
        RecentServices.add(place);
    }

    public void Booking_list(int user_id,Users a){
        Booking_details.put(user_id,a);
    }
    public void Checkby_admin(Users a){
        if(APPROVEDLIST.contains(a.user_id)){
            System.out.println("BOOKING APPROVED");
        }
        else if(REJECTEDLIST.contains(a.user_id)) {
            System.out.println("BOOKING REJECTED BY ADMIN");
            System.out.println("FOR QUERIES CONTACT 1234567890");
        }
        else{
            System.out.println("YOUR BOOKING IS STILL PENDING");
        }
    }
    int count =0;
    public void Booking_system(Users a,int option){
        Scanner sc = new Scanner(System.in);
        System.out.println("1.SERVICE"+" "+"2.BOOKING STATUS"+" "+"3.PREVIOUS BOOKINGS"+" "+"4.BACK");
        int options = sc.nextInt();
        switch (options){
            case 1:
                if(count>5){
                    System.out.println("SORRY SIR/MADAM TODAY'S BOOKING LIMIT IS OVER PLEASE VISIT NEXT DAY");
                    System.out.println("****************************************************************");
                    Booking_system(a,option);
                    break;
                }
                System.out.println("LIST OF TOP TEN SERVICE CENTERS OF OUR COMPANY");
                System.out.println("CITY ID"+"  "+"CITY");
                for(int i=0;i< cities.length;i++){
                    System.out.println(i+1+"  "+cities[i]);
                }
                int i=11;
                for(String q:RecentCities){
                    System.out.println(i+++"  "+q);
                }
                System.out.println("SELECT YOUR NEAR BY CITY BY ENTERING CITY ID");
                int city_no =sc.nextInt();
                System.out.println("SELECT THE REQUIRED SERVICE FROM THE LIST GIVEN BELOW");
                for( i=0;i< services.length;i++){
                    System.out.println(i+1+"  "+services[i]);
                }
                int j=2;
                for(String q:RecentServices){
                    System.out.println(j+++"  "+q);
                }
                int service_id =sc.nextInt();
                System.out.println("ENTER THE DATE IN DD/MM/YYYY FORMAT");
                String date = sc.next();
                if(city_no>10&&service_id<2){
                    System.out.println("CONFIRMATION OF CHOICE OF CITY");
                    System.out.println(RecentCities.get(city_no-11));
                    System.out.println("1.YES"+"  "+"2.NO");
                    int answer= sc.nextInt();
                    if(answer==1){
                        ++count;
                    }
                    if(answer!=1){
                        Booking_system(a,option);
                        break;
                    }
                    Booking_details.put(a.user_id,a);
                    System.out.println("YOUR BOOKING IS UNDER PROGRESS LOGIN AFTER SOMETIME TO CHECK BOOKING STATUS");
                    Users m = new Users(a.user_id,a.name,a.phone,a.email,RecentCities.get(city_no-11),date,services[service_id-1]);
                    Booking_list(m.refnumber,m);
                    Booking_system(a,option);
                    break;
                }
                else if(city_no<=10&&service_id<2){
                System.out.println(cities[city_no-1]);
                System.out.println("1.YES"+"  "+"2.NO");
                int answer= sc.nextInt();
                if(answer==1){
                    ++count;
                }
                if(answer!=1){
                    Booking_system(a,option);
                    break;
                }
                Booking_details.put(a.user_id,a);
                System.out.println("YOUR BOOKING IS UNDER PROGRESS LOGIN AFTER SOMETIME TO CHECK BOOKING STATUS");
                    Users m = new Users(a.user_id,a.name,a.phone,a.email,cities[city_no-1],date,services[service_id-1]);
                    Booking_list(m.refnumber,m);
                    Booking_system(a,option);
                     break;
                }
                else if(city_no>10&&service_id>2){
                    System.out.println(RecentCities.get(city_no-11));
                    System.out.println("1.YES"+"  "+"2.NO");
                    int answer= sc.nextInt();
                    if(answer==1){
                        ++count;
                    }
                    if(answer!=1){
                        Booking_system(a,option);
                        break;
                    }
                    Booking_details.put(a.user_id,a);
                    System.out.println("YOUR BOOKING IS UNDER PROGRESS LOGIN AFTER SOMETIME TO CHECK BOOKING STATUS");
                    Users m = new Users(a.user_id,a.name,a.phone,a.email,RecentCities.get(city_no-11),date,RecentServices.get(service_id-2));
                    Booking_list(m.refnumber,m);
                    Booking_system(a,option);
                    break;
                }
                else if(city_no<=10&&service_id>2){
                    System.out.println(cities[city_no-11]);
                    System.out.println("1.YES"+"  "+"2.NO");
                    int answer= sc.nextInt();
                    if(answer==1){
                        ++count;
                    }
                    if(answer!=1){
                        Booking_system(a,option);
                        break;
                    }
                    Booking_details.put(a.user_id,a);
                    System.out.println("YOUR BOOKING IS UNDER PROGRESS LOGIN AFTER SOMETIME TO CHECK BOOKING STATUS");
                    Users m = new Users(a.user_id,a.name,a.phone,a.email,cities[city_no-1],date,RecentServices.get(service_id-2));
                    Booking_list(m.refnumber,m);
                    Booking_system(a,option);
                    break;
                }
            case 2:
                System.out.println("YOUR BOOKING STATUS");
                Checkby_admin(a);
                Booking_system(a,option);
                break;

            case 3:
                int l=0;
                System.out.println("USER_ID"+" "+"NAME"+" "+"PHONE"+" "+"EMAIL"+" "+"PLACE"+" "+"DATE"+" "+"SERVICE");
                for(Users m : Booking_details.values()){
                    ++l;
                    if(l==1){
                        System.out.print("");
                    }
                    else{
                    System.out.println(m.user_id+" "+m.name+" "+m.phone+" "+m.email+" "+m.place+" "+m.date+" "+m.service);
                   }
                }
                Booking_system(a,option);
                break;
            case 4:
                Start();
                break;
        }

    }

public static void main(String[]args){
    Users a = new Users();
    a.Start();
   }
}