package model;

public class AppModel {
  //toa do
  //dem so lan bam
  //co o trong frame hay khong
  private int x,y;
  private int count;
  private boolean isInside;
  //! pheu dau tien set gia tri mac dinh
  public AppModel() {
    this.x=0;
    this.y=0;
    this.count=0;
    this.isInside=false;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getCount() {
    return count;
  }

  public boolean isInside() {
    return isInside;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public void setInside(boolean inside) {
    isInside = inside;
  }
}
