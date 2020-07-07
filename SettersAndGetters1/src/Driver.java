public class Driver{

  public static void main(String[] args){
    System.out.println("Test rectangle construction:");
    Rectangle defaultRec = new Rectangle();
    Rectangle square = new Rectangle(4.5, 4.5);
    Rectangle errorRec = new Rectangle(-1, -2);
    System.out.printf("defaultRec: length = %.2f, width = %.2f%n",
                     defaultRec.getLength(), defaultRec.getWidth());

    System.out.printf("square: length = %.2f, width = %.2f%n",
                      square.getLength(), square.getWidth());

    System.out.printf("errorRec: length = %.2f, width = %.2f%n%n",

                      errorRec.getLength(), errorRec.getWidth());

    System.out.println("Test setting various dimensions:");
    defaultRec.setLength(-10);
    defaultRec.setWidth(-5);
    System.out.printf("defaultRec: length = %.2f, width = %.2f%n",
        defaultRec.getLength(), defaultRec.getWidth());

    defaultRec.setLength(10);
    defaultRec.setWidth(5);
    System.out.printf("defaultRec: length = %.2f, width = %.2f%n%n",
        defaultRec.getLength(), defaultRec.getWidth());

    System.out.println("Test area and perimeter calculations:");
    System.out.printf("defaultRec: area = %.2f, perimeter = %.2f%n",
        defaultRec.getArea(), defaultRec.getPerimeter());
    System.out.printf("square: area = %.2f, perimeter = %.2f%n",
        square.getArea(), square.getPerimeter());
  }
}