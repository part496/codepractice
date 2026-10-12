//复习知识点

## 2026-10-13 JavaSE 复习：答错、遗忘与理解不完整的知识点

### 1. 包装类、自动装箱与拆箱

- **自动装箱**：基本类型转包装类，如 `Integer a = 100;`，本质上使用 `Integer.valueOf(100)`。
- **自动拆箱**：包装类转基本类型，如 `int b = a;`，本质上使用 `a.intValue()`。
- **`==` 比较**：两个引用类型用 `==` 比较是否为同一个对象；`Integer` 和 `int` 用 `==` 比较时，`Integer` 会自动拆箱，比较数值。
- **Integer 缓存**：`Integer.valueOf()` 默认缓存 **-128～127**；超出范围的两个 `Integer` 不应依赖 `==` 判断值相等（缓存上限可能因环境而扩展），比较数值优先用 `equals()`。
- **重载选择**：对于 `ArrayList<Integer>` 的 `remove(int index)` 和 `remove(Object o)`，传入 `Integer x = 1;` 时调用的是 `remove(Object)`，因为引用类型向上转型优先于拆箱匹配。

```java
Integer a = 200, b = 200;
int c = 200;
System.out.println(a == b); // 通常为 false，不要依赖引用比较数值
System.out.println(a == c); // true：a 自动拆箱

ArrayList<Integer> list = new ArrayList<>();
list.add(10);
list.add(20);
Integer x = 1;
list.remove(x); // 按元素值删除，集合中没有 1，因此不删除元素
```

### 2. IO 流、字符编码与序列化

- **字节流**（如 `FileInputStream` / `FileOutputStream`）：以字节处理数据，**也可以正确读写中文**，不仅用于图片等二进制文件。
- **字符流**（如 `FileReader` / `FileWriter`）：面向文本，帮我们在读写时完成字符与字节的编码/解码；仍然要注意字符集是否匹配。
- **编码**：`String → byte[]`，如 `"张三".getBytes(StandardCharsets.UTF_8)`。
- **解码**：`byte[] → String`，如 `new String(bytes, StandardCharsets.UTF_8)`；写入用 UTF-8、读取却用 GBK 可能乱码。
- 直接 `System.out.println(bytes)`（`bytes` 是 `byte[]`）**不会自动解码成中文**，通常输出类似 `[B@...` 的数组对象表示。
- **对象序列化**：`ObjectOutputStream` 将对象（含中文字符串）转成特定格式的字节数据；`FileOutputStream` 负责写入；`ObjectInputStream` 负责反序列化恢复对象。序列化文件用文本编辑器打开不可读，不等于中文丢失；`FileWriter` 不能代替对象序列化。

```java
byte[] bytes = "张三".getBytes(StandardCharsets.UTF_8);
System.out.println(new String(bytes, StandardCharsets.UTF_8)); // 张三
```

### 3. 多线程：Lambda、run/start、sleep/wait

- `new Thread(() -> { ... })` 中的 Lambda 是在实现 **`Runnable` 接口的 `run()`**；等价于创建一个实现了 `run()` 的 `Runnable` 对象，再传给 `Thread`。
- **`t.run()`**：普通方法调用，在当前线程中按顺序执行；**`t.start()`**：启动新线程执行任务，新线程和主线程谁先输出通常不确定。
- **`Thread.sleep(ms)`**：暂停当前线程指定时间，**不会释放已持有的锁**。
- **`lock.wait()`**：当前线程必须已持有 `lock` 的监视器，否则会抛 `IllegalMonitorStateException`；调用后释放 **`lock` 这把锁**并等待通知/唤醒。被 `notify()` / `notifyAll()` 唤醒后还要重新获得 `lock`，才能从 `wait()` 继续执行。

```java
Thread t = new Thread(() -> System.out.println("A"));
t.run();   // 当前线程直接执行
// t.start(); // 启动新线程；不要把它和 run() 当成同一件事
```

> 下次复习优先用代码题检验：包装类重载与拆箱、IO 编码/解码、多线程等待与锁。
