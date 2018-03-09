#!/usr/bin/env python
#-*- coding: utf-8 -*- 

"""
汉诺塔类型经典题目：
  有三根相邻的柱子，标号为A,B,C，A柱子上从下到上按金字塔状叠放着n个不同大小的圆盘，
  要把所有盘子一个一个移动到柱子B上，并且每次移动同一根柱子上都不能出现大盘子在小盘子上方，
  请问至少需要多少次移动？
"""

"""
	移动函数
		n A 柱子的圆盘数（已经排好序，将在 C 柱子还原同序）
		a 源盘
		b 辅助盘
		c 目标盘

	递归操作，打印移动步骤，计算移动次数
	移动次数满足规律：
		count = 2^n - 1
		code: 
			import math
			count = math.pow(2, n) - 1
"""
def move(n, a='A', b='B', c='C'):
	if n == 1:
		print('移动圆盘（单个）', a, ' ---> ', c);
		global count 
		count = count + 1
	else:
		move(n - 1, a, c, b)
		move(1, a, b, c)
		move(n - 1, b, a, c)


count = 0
number = input("请输入 A 柱中圆盘的数量：")
print('****** 递归计算 *******')

move(int(number))

print('****** 结束 ******')
print('圆盘从 A 柱 ---> C 柱：一共需要移动 ', count, ' 步!')

