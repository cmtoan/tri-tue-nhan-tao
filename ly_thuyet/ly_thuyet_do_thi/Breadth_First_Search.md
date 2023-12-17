# Breadth-First Search (BFS) : Tìm kiếm theo chiều rộng

## I. Tóm tắt

![](diagrams/graph1.svg)

Có đồ thị G(V,E) và mục đích là đi đến từng đỉnh V đúng một lần.

Breadth-First Search đi đến các đỉnh lân cận và các đỉnh lân cận của các đỉnh mới này cho đến khi tất cả các nút đều được đi đến.

- Độ phức tạp khi chạy thuật toán là O(V+E).
- Độ phức tạp về bộ nhớ thì không thuận lợi vì ta phải lưu trữ nhiều tham chiếu (references).


### Giải thích

Ta đi đến mỗi đỉnh đúng một lần, vì những đỉnh (V) này nối với nhau bởi các cạnh (E) nên ta cũng phải đi qua các cạnh.

Do đó, độ phức tạp của thuật toán là O(V+E) : V là số lượng các đỉnh (vertices), E là số lượng các cạnh (edges).

Vậy Tìm kiếm theo chiều rộng (BFS) có độ phức tạp tuyến tính.

Ta phải định đỉnh khởi đầu, trong trường hợp này là đỉnh A. Ta phải đi đến mọi đỉnh lân cận với nó, ở đây là đỉnh B và C. Vậy ta phải đi đến hai điểm này và những đỉnh lân cận với chúng. Ta phải đảm bảo rằng ta sẽ không đi đến một đỉnh đã từng được ghé qua rồi. Vậy ta sẽ đến đỉnh D, rồi đỉnh E và F.


### Ưu và khuyết điểm

Vì Breadth-First Search (BFS) cần nhiều bộ nhớ, thông thường thuật toán Depth-First Search (DFS) được ưu tiên.

BFS có một số ứng dụng, nhưng trong trường hợp có thể dùng BFS và DFS thì DFS được ưu tiên dùng do tốn ít bộ nhớ hơn.

BFS có ưu điểm là nó tạo một đường đi ngắn nhất. Thuật toán Dijkstra chủ yếu dùng BFS khi tất cả các cạnh có trọng số bằng 1.

BFS dựa chủ yếu vào kiểu dữ liệu hàng đợi (queue).


## II. Thuật toán

### Breadth-First Search

````
bfs(vertex):
	Queue queue
	set vertex to be visited
	queue.add(vertex)

	while queue not empty
		actual = queue.dequeue()

		for v in actual neighbors
			if v is not visited
				set v visited
			queue.add(v)
````

### Giải thích

Thuật toán này sử dụng kiểu dữ liệu hàng đợi (FIFO : first in first out)

Ban đầu ta có hàng đợi rỗng và ta kiểm tra xem ta có từng đi qua nốt này hay chưa.

Thuật toán kết thúc khi không còn nốt nào trong hàng đợi nữa.


## Code


````
````

````
````

````
````