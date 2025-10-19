
<h1 align="center">🏭 Event-Based Warehouse Inventory Tracker</h1>
<p align="center">
  <em>A Java console application that simulates real-time warehouse inventory management using the <strong>Observer Pattern</strong>.</em>
</p>

---

## 🚀 Features

<ul>
  <li>📦 <strong>Add Products Dynamically</strong></li>
  <li>🚚 <strong>Receive Shipments</strong> - Increase product quantity</li>
  <li>🧾 <strong>Fulfill Orders</strong> - Decrease product quantity</li>
  <li>⚠️ <strong>Automatic Restock Alert</strong> when stock < threshold</li>
  <li>🧠 Implements <strong>Observer Design Pattern</strong></li>
  <li>🧰 <strong>In-memory storage only</strong> (no database)</li>
  <li>💬 Graceful error handling for invalid IDs / insufficient stock</li>
</ul>

---

## 🧩 Class Structure

<table>
  <tr>
    <th>Class / Interface</th>
    <th>Description</th>
  </tr>
  <tr>
    <td><code>Product</code></td>
    <td>Represents an item in inventory (ID, Name, Quantity, Threshold)</td>
  </tr>
  <tr>
    <td><code>Warehouse</code></td>
    <td>Manages products and performs stock operations</td>
  </tr>
  <tr>
    <td><code>StockAlertService</code></td>
    <td>Interface to trigger alerts when stock is low</td>
  </tr>
  <tr>
    <td><code>Main</code></td>
    <td>Menu-driven console program for user interaction</td>
  </tr>
</table>

---

## ⚙️ Example Workflow

<pre>
Enter choice: 1
Enter Product ID: LAP101
Enter Product Name: Laptop
Enter Initial Quantity: 10
Enter Reorder Threshold: 5
✅ Product added successfully!

Enter choice: 3
Enter Product ID: LAP101
Enter Order Quantity: 6
✅ Order fulfilled for Laptop | Remaining: 4
🚨 Restock Alert: Laptop is low on stock! Only 4 left.
</pre>

---

## 🧠 Concepts Used

<ul>
  <li>Encapsulation, Abstraction, Loose Coupling</li>
  <li>Observer Design Pattern</li>
  <li>Collections (HashMap, List)</li>
  <li>OOP-based modular Java architecture</li>
</ul>

---

## 🧪 How to Run

<pre>
1. Clone the repository:
   git clone https://github.com/&lt;your-username&gt;/EventBasedInventoryTracker.git

2. Open the project in VS Code or Eclipse

3. Compile and run:
   javac *.java
   java Main
</pre>

---

## 📈 Future Enhancements

<ul>
  <li>Persist inventory data to a text file</li>
  <li>Add GUI or Web-based interface</li>
  <li>Multi-warehouse simulation with threading</li>
</ul>

---

## 👨‍💻 About the Developer

**Cheas**  
🎓 Computer Engineering Student | ☕ Java Developer | 💡 Future Software Engineer  

🌱 Currently learning: Core & Advanced Java, OOP, DSA, Web Dev  
💬 Fun fact: “I fix bugs faster when I’m listening to music 🎧”

---

<p align="center">
⭐ If you liked this project, give it a star on GitHub!
</p>
