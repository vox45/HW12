import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

// Базовий клас "Графічний об'єкт"
class GraphicObject {
    protected int x, y;
    protected Color color;

    public GraphicObject(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    // Метод для малювання графічного об'єкта (поліморфізм)
    public void draw(Graphics g) {
        g.setColor(color);
    }
}

// Підклас "Прямокутник"
class Rectangle extends GraphicObject {
    private int width, height;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillRect(x, y, width, height);
    }
}

// Підклас "Коло"
class Circle extends GraphicObject {
    private int radius;

    public Circle(int x, int y, int radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
}

// Підклас "Лінія"
class Line extends GraphicObject {
    private int x2, y2;

    public Line(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, color);
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawLine(x, y, x2, y2);
    }
}

// Клас "Графічний редактор"
class GraphicEditor {
    private ArrayList<GraphicObject> objects;

    public GraphicEditor() {
        this.objects = new ArrayList<>();
    }

    // Додавання графічного об'єкта
    public void addObject(GraphicObject object) {
        objects.add(object);
    }

    // Малювання всіх графічних об'єктів
    public void drawAll(Graphics g) {
        for (GraphicObject object : objects) {
            object.draw(g);
        }
    }
}

// Приклад використання
public class Main {
    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();

        // Додавання різних графічних об'єктів
        editor.addObject(new Rectangle(50, 50, 100, 80, Color.RED));
        editor.addObject(new Circle(200, 150, 30, Color.BLUE));
        editor.addObject(new Line(300, 50, 400, 150, Color.GREEN));

        // Створення вікна та виведення графічних об'єктів
        JFrame frame = new JFrame("Graphic Editor");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                editor.drawAll(g);
            }
        });

        frame.setVisible(true);
    }
}
