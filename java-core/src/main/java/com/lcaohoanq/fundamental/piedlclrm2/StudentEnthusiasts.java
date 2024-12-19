package com.lcaohoanq.fundamental.piedlclrm2;
//StudentEnthusiasts: Những người đam mê học tập
/*
    nếu bác thợ săn chỉ quan tâm đến học, vào lớp chỉ học
không quan tâm đến chú ngựa, không quan tâm đến bữa ăn
-> bác mê học hơn bữa cơm tối -> bác là một thành viên của StudentEnthusiasts 
    
    nếu như ngựa học chung với bác thợ săn mà ngựa không sợ ngựa chỉ tập
trung vào học, không quan tâm đến số mạng của mình coi việc học là trên hết
-> ngựa mê học hơn mạng sống  -> ngựa là một thành viên của StudentEnthusiasts

Hội StudentEnthusiasts chỉ chứa các thành viên mê học, chỉ bạn mê học là đủ,
không quan trọng chúng ta khác nhau thế nào, chỉ cần mê học là có thể trở thành
hội viên 

interface: là 1 class chỉ quan tâm đến method, không quan tâm props
           nếu có props thì sẽ là của chung
           nếu có method thì là abstract hoặc của chung
*/
public interface StudentEnthusiasts {
    //ai có thể tham gia câu lạc bộ này ? ai cũng được chỉ cần ham học là được
    //clb không quan tâm em là ai, đến từ đâu, xuất thân như thế nào
    //-> không có props, nhưng nếu em tạo props 
    //thì nó sẽ hiểu là đồ xài chung
    
    int QUAT = 120; //static 
    //public static final int QUAT = 120;
    //vì không có props, hoặc props luôn có giá trị
    //nên ta không cần cái phễu (constructor)
    //và không có getter | setter
    
    //trong interface tất cả các method đều là abstract
    //nếu method không phải abs thì phải là default hoặc static
    public double studyHard(); //method này là abs
    public void showProfile(); //in ra thông tin khi học
    
    
}
//trên thực tế thì interface chỉ nên chứa 1 method 
//để phục vụ cho lambda
//dù tạo không được constructor nhưng mà interface vẫn sẽ có một cái phễu rỗng
