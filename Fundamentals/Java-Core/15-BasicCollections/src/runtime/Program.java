package runtime;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;

public class Program {

    public static void main(String[] args) {
        //playWithArrayList();
        //playWithQueue();
        //playWithDeQue();

        //playWithSet();
        
        //playWithHashSet();
        
        playWithHashMap();
    }

    public static void playWithArrayList() {
        //ArrayList là 1 túi hàng hiệu dùng để triển khai
        //tính năng của List interface

        //ArrayList giống ArrayPrimitive, khác là co dãn được
        //tạo mảng thường
        int arrIntPrimitive[] = new int[10];
        //mảng bình thường lưu được primitive dataype, wrapper, obj
        //không co dãn được, rất ọp ẹp

        //ArrayList Collections
        ArrayList<Integer> arrIntList = new ArrayList<>();
        List<Integer> arrIntListV2 = new ArrayList<>();

        //khai cha new con
        //collections chỉ chơi với obj 
        //arrayList có tính co dãn
        arrIntList.add(new Integer(3));
        arrIntList.add(new Integer(5));
        arrIntList.add(2); //cơ chế auto - boxing

        System.out.println(arrIntList); //[3, 5, 2]
        //tự gọi hàm .toString

        //.clear(): xóa hết pt;
        arrIntList.clear();

        //--
        //.add(index, value): nhét value vào vị trí index
        arrIntList.add(0, 3);
        arrIntList.add(1, 5);
        arrIntList.add(2, 4);
        arrIntList.add(1, 4);

        //[3 4 5 4] -> nhét số 4 vào vị trí 1 đẩy các giá trị qua
        // 0 1 2 3 4 5 
        System.out.println(arrIntList);

        //.addAll (list) nhét list vào danh sách
        arrIntListV2.add(9);
        arrIntListV2.add(19);
        arrIntListV2.addAll(arrIntList); //[9 19 3 4 5 4 ]
        arrIntListV2.addAll(1, arrIntList); //[9 3 4 5 4 19 3 4 5 4]

        System.out.println(arrIntListV2);

        //---
        //giả sử có mảng cùi
        //Arrays.asList() : giúp chuyển mảng cùi thành mảng xịn
        Integer arrDemo[] = {3, 5, 7}; //auto-boxing
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(arrDemo));
        //arrList chính là phiên bản ArrayList của arrDemo

        //.toArray() chuyển mảng List thành arrayPrimitive
        Integer[] numList = new Integer[arrList.size()];
        arrList.toArray(numList);
        //không thể sout cho numList vì không có toString

        //.get(index): lấy ra phần tử ở vị trí index trong list
        //arrList[3,5,7];
        System.out.println(arrList.get(1));

        //set(index, newValue): gán giá trị ở index bằng newValue
        arrList.set(1, 9); //[3,9,7]

        //thử thách: swap số 3 và 7 đi
        Integer tmp = arrList.get(0);
        arrList.set(0, arrList.get(2));
        arrList.set(2, tmp);
        //arrList = [7, 9, 3];

        //iterable -- tính khả duyệt, tính khả lặp
        //iterator: khả lập, là 1 obj có thể định nghĩa là trình tự 
        //và giá trị có thể trả về tiếp theo trước khi kết thúc
        //xài fore khi nào cần gọi thì sẽ chạy ra giá trị tiếp 
        Iterator<Integer> it = arrList.iterator();
        System.out.println(it.hasNext()); //true
        System.out.println(it.next());//7
        System.out.println(it.next());//9
        System.out.println(it.next());//3
        //System.out.println(it.next());//false

        //HOG: callback, closure, lexicalScoping, Currying
        //học javaScript
        //.remove(index) xóa pt ở vị trí đó
        arrList.remove(1); //xóa số 9

        //.removeAll(list) xóa hết những thằng bên trong list
        //.size() lấy kích thước
        //.clone() sao chép tạo 1 mảng khác có cùng pt, kích thước, dung lượng
        //shallow copy => cắt không hết dây mơ rễ má, 2 chàng trỏ 1 nàng
        //deep copy    => cắt hớt
        //arrList = [7,3];
        //ArrayList<Integer> demoClone = arrList.clone(); //báo lỗi
        ArrayList<Integer> demoClone = (ArrayList) arrList.clone(); //báo lỗi
        //demoClone là bản sao của arrList
        demoClone.set(0, 15); //demoClone [15,3]
        //arrList   [7 ,3]

        //.contain(key); tìm kiếm sự tồn tại của phần tử (boolean)
        //notifyCapacity(): cung cấp giới hạn có thể chứa 
        //isEmpty(): xem mảng có rỗng không
        //trimToSize() giảm dung lượng về đúng kích thước
    }

    public static void playWithQueue() {
        //Queue là 1 interface có class triển khai là LinkedList
        Queue<Integer> numList = new LinkedList<>();
        //head [ ] tail 
        //.add(value) nhét value vào ds (true/illegalEx)
        //.offer (value) nhét value vào ds
        numList.add(3);
        numList.offer(1);
        numList.add(5);
        numList.offer(4);

        //Queue không xài add theo cách .add(index,value) này được
        //vì đó là hàng đợi, xài vậy là chen hàng đó
        //trong queue cũng không có get và set
        //vì không thể lấy pt ở vị trí bát kì được
        System.out.println(numList); //[3 1 5 4]

        //.element() xem pt ở đầu
        //ok    -> trả ra phần tử
        //ko có -> nullPonterEx
        System.out.println(numList.element()); //3
        System.out.println(numList.element()); //3

        //.peek() xem pt ở đầu  (pt, null)
        System.out.println(numList.peek()); //3

        //lấy ra
        //.remove() lấy pt đầu tiên ra khỏi ds
        //(pt, nullPointerEx)
        System.out.println(numList.remove()); //3
        System.out.println(numList.remove()); //1

        //.pool() lấy pt đầu tiên ra khỏi ds
        System.out.println(numList.poll()); //5
        //numList [4]

        //bth khi mà xài queue(hàng đợi) thì ngta thường k quan tâm
        //đến số lượng, hay hàng đợi có gì
        //ngta chỉ quan tâm giải quyết thằng đầu tiên, rồi tới thằng
        //tiếp theo mà thôi
        //vd như giải quyết vấn đề của khách hàng
        numList.offer(5);
        numList.offer(8);
        numList.offer(9);
        //numList [4 5 8 9]
        while (true) {
            Integer tmp = numList.poll(); //lấy ra thằng đầu hàng
            if (tmp == null) {
                break;
            }
            //doSomeThing
            System.out.println(tmp);
        }

        //PriorityQueue
        //PriorityQueue là class triển khai của Queue
        //nên giống Queue hoàn toàn
        //đặc biệt là nó có sự ưu tiên, nhỏ trước lớn sau
        Queue<Integer> numListV2 = new PriorityQueue<>();
        numListV2.offer(3);
        numListV2.offer(1);
        numListV2.offer(5);
        numListV2.offer(9);
        numListV2.offer(2);
        System.out.println(numListV2);
        //theory  [1 2 3 5 9]
        //reality [1 2 5 9 3] why?

        //thu ra bằng pool
        System.out.println(numListV2.poll()); //1
        System.out.println(numListV2.poll()); //2
        System.out.println(numListV2.poll()); //3?????
        System.out.println(numListV2.poll()); //5
        System.out.println(numListV2.poll()); //9

        //nếu như ta cần 1 hàng đợi bình thường, nhưng có giới hạn
        //chứa tối đa 3 người 
        //ArrayBlockingQueue
        Queue<Integer> numListV3 = new ArrayBlockingQueue<>(3);
        numListV3.offer(1);
        numListV3.offer(3);
        numListV3.offer(4);
        numListV3.offer(2);
        //numListV3.add(5);
        System.out.println(numListV3); //[1 3 2]

    }

    public static void playWithDeQue() {
        //Demo Deque thông qua ArrayDeque(là 1 class khai triển của Deque)

        Deque<Integer> numList = new ArrayDeque<>();

        //front -> "First" [ ] "Last" <- rear 
        //.add() | .addLast() | .offer() | .offerLast() nhét vào rear
        numList.add(4);
        numList.addLast(3);
        numList.offer(2);
        numList.offerLast(1);

        System.out.println(numList); //[4 3 2 1]

        //.addFirst() | .offerFirst() nhét vào đầu front
        numList.addFirst(7);
        numList.offerFirst(9);

        System.out.println(numList); //[9 7 4 3 2 1]

        //xem
        //.getFirst() | peelFirst() xem pt ở đầu front
        System.out.println(numList.getFirst()); //9
        System.out.println(numList.peekFirst()); //9

        //.getLast() | peekLast() xem pt ở đầu rear
        System.out.println(numList.getLast()); //1
        System.out.println(numList.peekLast()); //1

        //Xóa | Lấy ra
        //.removeFirst() | .pollFirst() lấy pt ở đầu front
        //.removeLast()  | .poolLast() lấy pt ở đầu rear
        //ArrayDeque thay thế cho cấu trúc Queue
        //front rear           ->         head tail
        //thêm : .offerLast()
        //xem  : .peekFirst()
        //xóa  : .poolFirst()
        //ArrayDeque thay thế cho cấu trúc Stack(xếp chồng LIFO)
        //thêm first ra first
        //thêm: .offerFirst()
        //xem : .peekFirst()
        //xóa : .poolFirst()
    }

    //byMe
    public static void playWithSet() {
        Set s = new TreeSet();

        s.add((Integer) 99); //sẽ bị dồn về cuối cùng
        
        s.add(4);
        s.add(6);
        s.add(12);

        s.add((Integer) 16); //dồn về đằng trước thằng cuối cùng

        s.add(7);

        s.remove(7);
        
        System.out.println("Demo Treeset");

//        for (Object item : s) {
//            item.toString();
//        }
        Iterator iter = s.iterator();
        while (iter.hasNext()) {
            System.out.printf(iter.next() + ", "); //4, 6, 12, 16, 99
        }

    }
    
    public static void playWithHashSet(){
        Random random = new Random();
        
        HashSet myset = new HashSet();
        
        for(int i = 0; i < 10; i++){
            int number = random.nextInt(100);
            myset.add(number);
        }
        
        Iterator iter = myset.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        
    }
    
    public static void playWithHashMap(){
        //Tái = 20000
        //Tái nạm = 25000
        //Gà = 150000
        
        //Trong HashMap chỉ lưu cặp key, value là object, bọc lại bằng Wrapper
        HashMap<String, Integer> bangGia = new HashMap<>();
        bangGia.put("Tái", 20000);
        bangGia.put("Tái nạm", 25000);
        bangGia.put("Gà", 15000);
        
        System.out.println(bangGia); //{Gà=15000, Tái=20000, Tái nạm=25000}
        //thứ tự không xác định
        //hỗ trợ cho việc tìm kiếm rất nhanh
        
        System.out.println(bangGia.get("Tái nạm")); //25000
        System.out.println(bangGia.values()); //[15000, 20000, 25000]
        
        //lấy tất cả các key = keySet()
        System.out.println(bangGia.keySet()); //[Gà, Tái, Tái nạm]
       
        for (String pho : bangGia.keySet()) {
            System.out.println(pho + "-" + bangGia.get(pho));
//            Gà-15000
//            Tái-20000
//            Tái nạm-25000
        }
        
        //kiểm tra key nào đó có nằm trong map hay khôn
        System.out.println(bangGia.containsKey("Gà")); //true
        System.out.println(bangGia.containsKey("Heo")); //false
        System.out.println(bangGia.containsValue(15000)); //true
        
        //Map không cho phép các key trùng nhau
        bangGia.put("Gà", 13000);
        //Map sẽ cài một cặp mới, nếu key không tồn tại
        //ở đây key gà đã có, nên sẽ cập nhật lại giá trị mà key đó liên kết đeens
        
        //replace
        //nếu key tồn tại, thì cập nhật giá trị
        bangGia.replace("Gà", 16000);
        //nếu key không tồn tại, thì không làm gì
        bangGia.replace("Hủ tiếu", 15000);
        System.out.println(bangGia); //{Gà=16000, Tái=20000, Tái nạm=25000}
        
        //putIfAbsent
        //Nếu không có thì tạo cặp mới
        bangGia.putIfAbsent("Tái Bò Viên", 30000);
        //Nếu có thì không làm gì
        bangGia.putIfAbsent("Tái", 20000);
        System.out.println(bangGia); //{Gà=16000, Tái Bò Viên=30000, Tái=20000, Tái nạm=25000}
        
        //kiểm tra xem kích thước của một map
        System.out.println(bangGia.size()); //4
        
        //remove
        //nhận vào key của cặp muốn xoá
        //xoá xong trả về giá trị của key
        //không tồn tại thì trả về null
        bangGia.remove("Gà");
        System.out.println(bangGia); //{Tái Bò Viên=30000, Tái=20000, Tái nạm=25000}
        
    }
}
