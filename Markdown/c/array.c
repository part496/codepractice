1:
指针本身只保存地址 若要修改指针地址所指向的内容 要看指针指向的内存是否可以修改
例：char *p = "hallo" 指向只读区 不可修改
char p[] = "hello" 可以修改
char *p = malloc 可以修改
