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

## 单链表是否有环的问题
流程：一开始快慢指针都在开始节点处。快指针走两步，慢指针走一步。然后一直走。如果相遇，快指针回到开始节点处，开始走一步，慢指针也走一步，下一次相遇的时候就是环的入口。
 通过计算a和b走的位置可以推导出来。
 ![image](https://user-images.githubusercontent.com/43565774/142207642-041fc64c-815b-4c76-9b94-c4006bf3a1fc.png)


![image](https://user-images.githubusercontent.com/43565774/142204359-3b6bd820-aa26-421d-8915-1c57cb0e0c44.png)


## 两个单链表相交的问题
![image](https://user-images.githubusercontent.com/43565774/142204613-79d522e5-27e2-4b7d-8835-b3b9a72f6109.png)

1.先根据上面的方法判断两个链表有没有环。
2如果两个链表都没有环的话，则说明两个单链表要么没有相交，要么尾部的一小段是公共部分。
 这个时候就分别遍历两个链表，记录长度和尾结点，看一下尾结点的内存地址是不是同一个，如果不是同一个，则肯定不想交。
 如果是同一个，就根据两个链表的长度，长的先走到剩余长度一致的节点，然后一起遍历，直到找到内存地址一样的节点，这个就是相交部分第一个节点。
 
3.如果一个有环一个无环，则不可能相交的。
4.如果两个都有环：
  ![image](https://user-images.githubusercontent.com/43565774/142335167-abff9244-c9d5-4aac-9c56-c5a22e371a70.png)
  通过上面的方法我们可以拿到两个环的入环位置。如果相等，则变成了2的方法找相交部分。
  如果不相等，就要区分一下图中1和3两种情况：
 让loop1继续往下走，直到转了一圈。
     - 如果能遇到loop2就是3的情况，相交，返回loop1或者loop2都可以，都算相交的节点。
     - 如果遇不到loop2就是1的情况。 不想交


![image](https://user-images.githubusercontent.com/43565774/142336010-5d834c73-3d6a-476f-808f-f1582a387e9c.png)


# 二叉树
## 递归遍历
![image](https://user-images.githubusercontent.com/43565774/142337278-120e5275-fd69-415a-8cc1-31a7a2dcb965.png)

## 非递归遍历
自己进行压栈的操作。
- 先序遍历：
头结点放入。栈弹出一个头节点弹出，然后打印，然后右节点加入栈中，左节点加入栈中。周而复始直到栈中元素为空。
注意先压右节点再压左节点

![image](https://user-images.githubusercontent.com/43565774/142418160-c72f1041-1001-4b4b-9d8a-830208e8a8d0.png)

- 中序遍历


左子树一溜烟儿进栈，相当于找到最左子节点，然后弹出，打印。然后右节点进栈，右节点的左子节点跟着一溜烟儿进栈。然后返回开始周而复始。直到栈中元素为空。

![image](https://user-images.githubusercontent.com/43565774/142419929-989b9ca9-3c3c-49d7-8a69-b9ece28decd9.png)


![image](https://user-images.githubusercontent.com/43565774/142420645-4a4cd13f-3eed-4925-9534-616ff213b190.png)



- 后续遍历

借助一个辅助的栈，按照先序遍历的方法压栈，改成弹出一个节点以后放入到辅助栈中，然后先压右边再压左边子节点的思路。最后压栈为空的时候，挨个弹出辅助栈，就成了后续遍历了。

![image](https://user-images.githubusercontent.com/43565774/142418738-d23990ea-809d-4c7c-8846-88d565339640.png)
![image](https://user-images.githubusercontent.com/43565774/142419498-75ea6f21-e8d5-4138-b107-4ee68a101585.png)

## 求二叉树的宽度
层次遍历，统计栈的长度。
或者搞一个队列，搞一个hashmap，key为node，value为层数。然后按照层次遍历，统计每一层的数量。
![image](https://user-images.githubusercontent.com/43565774/142424040-fe0736b0-dda3-4f43-b2da-d90960f143b3.png)

如果就是用一个队列的话，可以搞两个变量，一个记录当前层最后一个node，一个记录下一层最后一个node。当前遍历的节点不是当前层最后一个node，在将左右孩子加入到队列的时候，就更新下一层最后一个node。如果等于当前层最后一个node，则将左右孩子入队列以后，当前最后一个node指向下一层最后一个node，下一层最后一个node志为空。同时在这个过程中记录节点的个数，更新最大宽度。



