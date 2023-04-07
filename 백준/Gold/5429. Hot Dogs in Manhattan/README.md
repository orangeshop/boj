# [Gold II] Hot Dogs in Manhattan - 5429 

[문제 링크](https://www.acmicpc.net/problem/5429) 

### 성능 요약

메모리: 40016 KB, 시간: 624 ms

### 분류

그래프 이론, 그래프 탐색, 이분 탐색, 너비 우선 탐색

### 문제 설명

<p>The two friends Barack and Mitt have both decided to set up their own hot dog stand in Manhattan. They wish to find the two optimal locations for their stands.</p>

<p>First of all, they both want to put their stand at an intersection, since that gives them maximum exposure. Also, this being Manhattan, there are already quite a few stands in the city, also at intersections. If they put up a stand close to another (or each other’s) stand, they might not get that many customers. They would therefore like to put their stands as far from other stands as possible.</p>

<p>We model Manhattan as a finite square grid, consisting of w vertical streets and h horizontal streets. The vertical streets run from x = 0 to x = w − 1, while horizontal streets run from y = 0 to y = h−1. All pairs of consecutive parallel streets are separated by the same distance, which we set as the unit distance. The distance between two intersections (x<sub>1</sub>, y<sub>1</sub>) and (x<sub>2</sub>, y<sub>2</sub>) is then given by |x<sub>1</sub> − x<sub>2</sub>| + |y<sub>1</sub> − y<sub>2</sub>|.</p>

<p>We indicate an intersection’s suitability by its privacy, which is the minimum of all distances from this intersection to all other hot dog stands. Barack and Mitt would like to find two intersections with the maximum amount of privacy, i.e. such that the smallest of the two privacies is as large as possible. Note that the privacy of Barack’s location can be determined by the distance to Mitt’s location and vice versa.</p>

### 입력 

 <p>On the first line one positive number: the number of test cases, at most 100. After that per test case:</p>

<ul>
	<li>one line with three space-separated integers n, w and h (0 ≤ n ≤ 1 000 and 2 ≤ w, h ≤ 1 000): the number of hot dog stands already in place and the number of vertical and horizontal streets, respectively.</li>
	<li>n lines, each with two space-separated integers x<sub>i</sub> and y<sub>i</sub> (0 ≤ x<sub>i</sub> < w and 0 ≤ y<sub>i</sub> < h): the intersection where the i-th hot dog stand is located.</li>
</ul>

<p>All hot dog stands are at different intersections. At least two intersections do not contain a stand.</p>

### 출력 

 <p>Per test case:</p>

<ul>
	<li>one line with one integer: the maximum privacy that Barack and Mitt can both obtain.</li>
</ul>

