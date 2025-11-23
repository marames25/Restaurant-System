package restaurant.menu.component;

public abstract class MenuComponent {

    public abstract void display();

    public void addComponent(MenuComponent component) { }
    public void removeComponent(MenuComponent component) { }
}
