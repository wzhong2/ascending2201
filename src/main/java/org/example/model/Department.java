package org.example.model;

public class Department {
    private long id;
    private String name;
    private String description;
    private String location;


    public Department() {}
        public Department(long id, String name, String description, String location){
            this.id = id;
            this.name = name;
            this.description = description;
            this.location = location;
        }
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
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }



    }

