# 图

![image](https://user-images.githubusercontent.com/43565774/142758750-d7ee486b-38b2-4b2b-958d-0399c5511f58.png)

表达图的一种方式
表示node的描述
![image](https://user-images.githubusercontent.com/43565774/142759443-88012d8e-dd5b-43f0-a2f3-bc297580ce16.png)
从上到下，分别是
- 值
- 入度
- 出度
- 由这个点指向的点的集合
- 指向这个点的集合

表示边的描述
![image](https://user-images.githubusercontent.com/43565774/142759537-dba9a3aa-e7ef-4716-a095-6d902dd50a39.png)
- 权值
- 从哪个点起
- 指向哪个点

图的表示，边集和点集

![image](https://user-images.githubusercontent.com/43565774/142759679-95421d22-2b96-4681-9b32-d3a4753945b6.png)

根据二维矩阵构建上面的图的代码
![image](https://user-images.githubusercontent.com/43565774/142759766-81df64fe-81ae-4ee2-b917-8d0b186511b6.png)

## 图的宽度优先遍历
![image](https://user-images.githubusercontent.com/43565774/142759860-a07c5d09-3996-41a9-b7f5-9650028eee9c.png)
![image](https://user-images.githubusercontent.com/43565774/142759911-078d0e38-bda0-49aa-8b4f-9f91c181d2b7.png)





## 图的广度优先遍历

![image](https://user-images.githubusercontent.com/43565774/142760807-8415810b-d085-452f-8411-4cb220a1270c.png)
栈里面的每个节点都是访问过的，因此下次只是弹出来寻找深度下一个节点，如果找到了，就把这两个都加入到栈中，然后访问下一个节点，将下一个节点保存到set中。set的作用就是保存已经访问过的节点。

