package restaurant.menu.component;

import java.util.ArrayList;
import java.util.List;

public class Menu extends MenuComponent {

    protected List<MenuComponent> components;
    protected String type;

    public Menu(String type) {
        this.type = type;
        components = new ArrayList<>();
    }

    @Override
    public void display() { 
        System.out.println(type + " menu: ");

        for (MenuComponent mc : components) {
            mc.display();
        }
    }

    @Override
    public void addComponent(MenuComponent component) {
        components.add(component);
    }

    @Override
    public void removeComponent(MenuComponent component) {
        components.remove(component);
    }


}
