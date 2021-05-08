# eCommerceDemo

### Creating Layers which names are business, core, dataAccess, entities

![image](https://user-images.githubusercontent.com/83074390/117535307-dfb99400-affd-11eb-9082-1588dd41a391.png)


    
### Adding Course to List Using Different Ways
```Java
    Course course1 = new Course();
    course1.setId(1);
    course1.setName("Yazılım Geliştirici Yetiştirme Kampı(C# + Angular)");
    course1.setInstructor("Engin Demiroğ");
    course1.setCategoryid(1); 
    
    Course course2 = new Course(1,"Yazılım Geliştirici Yetiştirme Kampı(Java + React)","Engin Demiroğ",1);
    Course course3 = new Course(1,"Programlamaya Giriş için Temel Kurs","Engin D.",1);
		
    Course[] courses = {course1,course2 ,course3};
```
### Adding Category
```Java
    Category category = new Category(1,"Programlama");
    Category[] categories = {category};
```

### Adding Instructor
```Java
    Instructor instructor = new Instructor(1,"Engin Demiroğ"); //instantiation
    Instructor[] instructors = {instructor};
```
### Listed Courses By Selected Instructor
```Java
public class InstructorManager {   
	
public static void listCourseByInstructor(Course courses[], String instructor) {
		
		for (Course course : courses) {
			if (course.getInstructor() == instructor) {
				System.out.println(course.getName()); 
			}		
		}
	}
}

InstructorManager instructorManager = new InstructorManager();
instructorManager.listCourseByInstructor(courses, "Engin Demiroğ");
```
### Result :
##### Yazılım Geliştirici Yetiştirme Kampı(C# + Angular)
##### Yazılım Geliştirici Yetiştirme Kampı(Java + React)

### Listed Courses By Selected Category
```Java
public class CategoryManager {  
	
	//Listing courses by selected category
	public static void listCourseByCategory(Course courses[], int categoryid) {
		
		for (Course course : courses) {
			if (course.getCategoryid() == categoryid) {
				System.out.println(course.getName()); 
			}		
		} 
	} 

}

CategoryManager categoryManager = new CategoryManager();
categoryManager.listCourseByCategory(courses, 1);
```
### Result :
##### Yazılım Geliştirici Yetiştirme Kampı(C# + Angular)
##### Yazılım Geliştirici Yetiştirme Kampı(Java + React)
##### Programlamaya Giriş için Temel Kurs

### Signed Up a Course
```Java
public class CourseManager { 
	
	String fullname; 
	String email;
	String password;
	
	public static String signUpCourse(String fullname, String email, String password) {		
		return "Signed up successfully.";
	}
 
} 
