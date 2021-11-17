对于hash结构，如果是自定义的类的实例作为key则传递的是内存的地址，只占了八个字节，如果是string或者基本数据类型比如int 、char这种，则是值传递。比如string的长度特别长，key就是深拷贝，栈的内存也就响应的非常的长。

# 链表
## 回文链表
空间复杂度为o(1)
快慢指针,从终点开始，将后半段翻转，然后用头尾节点遍历开始比对
```
node node1 = head;
node node2 = head;
while(node2.next!=null&&node2.next.next!=null){
  node1=node1.next;
  node2=node2.next.next;
}

```
![image](https://user-images.githubusercontent.com/43565774/142095356-102e2456-154b-4a69-8741-8297cc0df337.png)
![image](https://user-images.githubusercontent.com/43565774/142095813-184c2d8a-b460-4225-94a6-03832ea7fa52.png)

## 用快排的思想实现单链表的排序
借助六个变量。分别是小于基准节点的子链表头尾节点、大于的头尾、等于的头尾。然后合并小于和等于的部分。然后分别对两个子链表递归执行以上操作。返回以后就合并两个子链表。基本跟快拍的操作一致。

## 复制带rand指针的单链表，要求空间复杂度01
![image](https://user-images.githubusercontent.com/43565774/142204359-3b6bd820-aa26-421d-8915-1c57cb0e0c44.png)

将复制的节点直接连在原来节点的后面，然后执行复制节点的rand节点的指向操作。然后去掉老节点就是新的复制的链表，
![image](https://user-images.githubusercontent.com/43565774/142204315-a050c13c-f9b3-4507-b91d-96454758b0c9.png)

![image](https://user-images.githubusercontent.com/43565774/142203370-5b7792a7-ff35-498e-8c26-ffbb7177ca83.png)
