1:
指针本身只保存地址 若要修改指针地址所指向的内容 要看指针指向的内存是否可以修改
  
例：
a: char *p = "hallo" 指向只读区 不可修改
  
b: char arr[] = "hello"
char *p = arr 可以修改

c: char *p = (char*)malloc() 可以修改
  
后面两个的共同点在于都是创造了一片空间 所以他才能修改
