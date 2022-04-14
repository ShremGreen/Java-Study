package collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
    private String[] courses;
    private List<String> list;
    private Map<String,String> maps;
    private Set<String> set;

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }
}
