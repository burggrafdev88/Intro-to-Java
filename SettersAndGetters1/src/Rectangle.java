
public class Rectangle {
  private double length;
  private double width;
  
  Rectangle(){
    setLength(1);
    setWidth(1);
  }
  
  Rectangle(double length, double width){
    setLength(length);
    setWidth(width);
  }
  
  
  public double getLength() {
    return length;
  }
  
  public void setLength(double length) {
    if(length > 0) {
      this.length = length;
    }
  }
  
  public double getWidth() {
    return width;
  }
  
  public void setWidth(double width) {
    if(width > 0) {
      this.width = width;
    }
  }
  
  public double getArea() {
    double area = length*width;
    return area;
  }
  
  public double getPerimeter() {
    double perimeter = (2*length) + (2*width);
    return perimeter;
  }
	
}
