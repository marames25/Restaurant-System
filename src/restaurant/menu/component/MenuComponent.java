package restaurant.menu.component;

public abstract class MenuComponent {

    public abstract String display();

    public void addComponent(MenuComponent component) { }
    public void removeComponent(MenuComponent component) { }
}
