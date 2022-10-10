package guru.springframework.sfgpetclinic.fauxspring;

import java.util.HashMap;
import java.util.Map;

public class ModelMapImpl implements Model {

    Map<String , Object> attributesMap=new HashMap<>();

    public Map<String, Object> getAttributesMap() {
        return attributesMap;
    }

    public void setAttributesMap(Map<String, Object> attributesMap) {
        this.attributesMap = attributesMap;
    }

    @Override
    public void addAttribute(String key, Object o) {
        this.attributesMap.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {

    }
}
