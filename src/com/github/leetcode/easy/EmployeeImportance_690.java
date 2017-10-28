package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 

You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.

Example 1:
Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
Output: 11
Explanation:
Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
Note:
One employee has at most one direct leader and may have several subordinates.
The maximum number of employees won't exceed 2000.

 * @author Samuel
 *
 */
public class EmployeeImportance_690 {

	public static void main(String[] args) {
		Employee employee1 = new Employee(1, 5);
		Employee employee2 = new Employee(2, 3);
		Employee employee3 = new Employee(3, 3);
		employee1.addSubordinate(2);
		employee1.addSubordinate(3);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(employee3);
		employees.add(employee2);
		employees.add(employee1);
		System.out.println("Samuel Test getImportance = " + getImportance1(employees, 1));
		
		System.out.println("Samuel Test getImportance = " + getImportance2_dfs(employees, 1));
		System.out.println("Samuel Test getImportance = " + getImportance3_bfs(employees, 1));
	}
	
	// Solution1 ---- Use stream API to solve this problem.
	static int result = 0;
	public static int getImportance1(List<Employee> employees, int id) {
		Employee e = employees.stream().filter(a -> a.id == id).collect(Collectors.toList()).get(0);
		result += e.importance;
		e.subordinates.forEach(a -> getImportance1(employees, a));
        return result;
    }
	
	// Solution2 ---- Use dfs to solve this problem.
	public static int getImportance2_dfs(List<Employee> employees, int id) {
		// for HashMap --- get(), containsKey() --- O(1)
		Map<Integer, Employee> data = new HashMap<>();
		for (Employee e : employees) {
			data.put(e.id, e);
		}
		return getImportance2_dfsHelper(data, id);
	}
	
	public static int getImportance2_dfsHelper(Map<Integer, Employee> data, int id) {
		Employee employee = data.get(id);
		int result = employee.importance;
		for (int subId : employee.subordinates) {
			result += getImportance2_dfsHelper(data, subId);
		}
		return result;
	}
	
	// Solution3 ---- Use bfs to solve this problem. --- Time complexity: O(n) --- Space complexity: O(n)
	public static int getImportance3_bfs(List<Employee> employees, int id) {
		Map<Integer, Employee> data = new HashMap<>();
		for (Employee e : employees) {
			data.put(e.id, e);
		}
		
		// bfs --- we need use one Queue as a helper
		// for linkedList implemented Queue --- offer(), peek(), poll() --- O(1)
		Queue<Employee> queue = new LinkedList<>();
		queue.offer(data.get(id));
		int total = 0;
		while (!queue.isEmpty()) {
			Employee e = queue.poll();
			total += e.importance;
			for (int subId : e.subordinates) {
				queue.offer(data.get(subId));
			}
		}
		return total;
	}
	
	// Employee info
	static class Employee {
	    // It's the unique id of each node;
	    // unique id of this employee
	    public int id;
	    // the importance value of this employee
	    public int importance;
	    // the id of direct subordinates
	    public List<Integer> subordinates;
	    
	    Employee(int id, int importance) {
	    	this.id = id;
	    	this.importance = importance;
	    	this.subordinates = new ArrayList<Integer>();
	    }
	    
	    public void addSubordinate(int id) {
	    	this.subordinates.add(id);
	    }
	};
}
