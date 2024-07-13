//RightTriangle : tam giác vuông 
package data;
//Triangle và Rightangle có thể sống độc lập
//Đối với những yêu cầu rắc rối cần phải xác định cha và con ?
//Phân biệt ai cha ai con ?
//Trong java có mối quan hệ kế thừa cha con "is a"
//Triangle is a Rightangle => SAI
//Rightangle is a Triangle => ĐÚNG
//    con           cha
//tại sao phải kế thừa ? (ý nghĩa của kế thừa là gì?)
//xài lại để đỡ viết code
//những gì mà họ làm chưa tốt với mình thì mình phát triển tiếp
//      mở rộng
//  “kế thừa cái tốt, phát triển cái chưa tốt”
//extends: mở rộng
//1. class cha sở hữu những cái chung (vì cái riêng thì con sẽ sở hữu)
//2. class con sẽ chứa cái riêng của nó
public class RightTriangle extends Triangle {
    //thuộc tính riêng của tam giác vuông là gì ?
    //double canhHuyen; -> ke thua class cha -> da co 3 canh a,b,c roi
    //không có thuộc tính riêng
    //con luôn bự hơn cha -> sở hữu những gì cha có, phát huy thêm
    
    public RightTriangle(double edgeA, double edgeB) {
        super(edgeA, edgeB, Math.sqrt(edgeA*edgeA + edgeB*edgeB));
    }
    //super: new Cha : new Triangle
    //cha cần 3 cạnh, con cần 2 cạnh ?  xung đột
        //method showInfor:
    @Override
    public void showInfor(){
        String str = String.format("RightTriangle |%5.2f |%5.2f |%5.2f |%5.2f |%5.2f"
                , edgeA, edgeB, edgeC, getPerimeter(), getArea());
        System.out.println(str);
    }
    
}
//những lưu ý khi đi phỏng vấn:
//class con to hay nhỏ hơn class cha ? To hơn
//Con kế thừa cha, cha cho con hết những gì cha có
//con còn có thêm những cái riêng của nó nữa

//trong constructor của con có new Cha
//=> muốn tạo con thì phải tạo thằng cha bên trong trước

//override và overload
//override là gì?
//override chỉ xuất hiện trong mối quan hệ cha con
//khi con độ hàm của cha
//tạo ra một hàm khác cùng tên với hàm của cha
//overload khi nào ?
//không quan tâm mối quan hệ
//chỉ cần hàm cùng tên != para (đầu vào) thì có overload