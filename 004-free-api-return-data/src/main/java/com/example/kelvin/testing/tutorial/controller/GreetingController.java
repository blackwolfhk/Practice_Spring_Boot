package com.example.kelvin.testing.tutorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @RequestMapping("/testing")
    public List<MyObject> getGreeting(){
        List<MyObject> myObjects = new ArrayList<>();

        MyObject obj1 = new MyObject();
        obj1.setMethod("Testing API");
        obj1.setMessage("Hello!");
        obj1.setAuthor("Kelvin");

        SubObject subObj1 = new SubObject();
        subObj1.setDescription("This is a subobject.");
        obj1.setSubObject(subObj1);

        List<String> tags1 = new ArrayList<>();
        tags1.add("tag1");
        tags1.add("tag2");
        obj1.setTags(tags1);

        Map<String, Integer> data1 = new HashMap<>();
        data1.put("key1", 1);
        data1.put("key2", 2);
        obj1.setData(data1);

        CustomEnum customEnum1 = CustomEnum.VALUE1;
        obj1.setCustomEnum(customEnum1);

        myObjects.add(obj1);

        MyObject obj2 = new MyObject();
        obj2.setMethod("Testing API");
        obj2.setMessage("Hi there!");
        obj2.setAuthor("Jane");

        SubObject subObj2 = new SubObject();
        subObj2.setDescription("This is another subobject.");
        obj2.setSubObject(subObj2);

        List<String> tags2 = new ArrayList<>();
        tags2.add("tag3");
        tags2.add("tag4");
        obj2.setTags(tags2);

        Map<String, Integer> data2 = new HashMap<>();
        data2.put("key3", 3);
        data2.put("key4", 4);
        obj2.setData(data2);

        CustomEnum customEnum2 = CustomEnum.VALUE2;
        obj2.setCustomEnum(customEnum2);

        myObjects.add(obj2);

        return myObjects;
    }

    public static class MyObject {
        private String method;
        private String message;
        private String author;
        private SubObject subObject;
        private List<String> tags;
        private Map<String, Integer> data;
        private CustomEnum customEnum;


        public String getMethod(){
            return method;
        }

        public void setMethod(String method){
            this.method = method;
        }

        public String getMessage(){
            return message;
        }

        public void setMessage(String message){
            this.message = message;
        }

        public String getAuthor(){
            return author;
        }

        public void setAuthor(String author){
            this.author = author;
        }

        public SubObject getSubObject() {
            return subObject;
        }

        public void setSubObject(SubObject subObject){
            this.subObject = subObject;
        }

        public List<String> getTags(){
            return tags;
        }

        public void setTags(List<String> tags){
            this.tags = tags;
        }

        public Map<String, Integer> getData(){
            return data;
        }

        public void setData(Map<String, Integer> data){
            this.data = data;
        }

        public CustomEnum getCustomEnum() {
            return customEnum;
        }

        public void setCustomEnum(CustomEnum customEnum) {
            this.customEnum = customEnum;
        }
    }

    public static class SubObject {
        private String description;

        public String getDescription(){
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public enum CustomEnum {
        VALUE1,
        VALUE2,
        VALUE3
    }
}
