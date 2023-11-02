package kr.ac.mjc.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ExampleController {

    @GetMapping("/example")
    public String example(Model model){
        Person person=new Person();
        person.setId(2l);
        person.setName("진용화");
        person.setAge(35);
        person.setHobbies(List.of("운동","독서"));

        model.addAttribute("person",person);
        return "example";
    }

    class Person{
        private long id ;
        private String name;
        private int age;
        private List<String> hobbies;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public List<String> getHobbies() {
            return hobbies;
        }

        public void setHobbies(List<String> hobbies) {
            this.hobbies = hobbies;
        }
    }
}
