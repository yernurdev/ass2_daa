# Assignment 2 — Heap Sort Analysis & Implementation

## 📘 Overview
This repository contains my implementation and analysis for **Assignment 2: Algorithmic Analysis and Peer Code Review**.  
The project implements **Heap Sort (in-place, bottom-up heapify)** using Java and Maven, following all requirements from the assignment guidelines.

The repository includes:
- Full source code and unit tests
- Performance tracking (comparisons, swaps, array accesses, runtime)
- Benchmark CLI for empirical testing
- Analysis report (PDF)
- Performance plots and CSV files

---


---

## 🧠 Algorithm Description

**Heap Sort** builds a max-heap structure from an unsorted array,  
then repeatedly extracts the maximum element and rebuilds the heap until sorted.

**Key properties:**
- **Time complexity:**
    - Best: Ω(n log n)
    - Average: Θ(n log n)
    - Worst: O(n log n)
- **Space complexity:** O(1) auxiliary (in-place)
- **Stability:** Not stable
- **Optimization:** Bottom-up heapify used for efficient heap construction.

---

## ⚙️ Build & Run

### 1️⃣ Run unit tests
```bash
mvn test
```


### 2️⃣ Run benchmarks
```bash
mvn compile exec:java
```

### 3️⃣ Output files
docs/performance-plots/

### Each CSV file contains:
n,time_ms,comparisons,swaps,array_accesses


