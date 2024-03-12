#include<bits/stdc++.h>
#include<windows.h>
#define LD long double

using namespace std;

ofstream out;

const LD max_v = 100;
const LD max_a = 5;
const LD F_max = 5;
const LD f_max = 5;
const LD mv = 1;
const LD p1 = 1;
const LD p2 = 0;
int k;
LD v;
LD t;
const LD k1 = 1; // ¶¯Á¦ 
const LD k2 = 2; // ·ÉÂÖ 
const LD k3 = 0.5; // É²³µ 
const LD k4 = 0.01; // ·ç×è 

void line(const string text, const int &p) {
	if (p > 100 || p < 0) {
		cout << "wrong\n";
		return;
	}
	cout << text << p << " ";
	cout << "|";
	for (int i = 1; i <= p; i++) cout << "-";
	cout << "|";
	for (int i = 1; i <= 100-p; i++) cout << " ";
	cout << "|" << endl;
}

void print(const LD &t, const LD &v, const LD &a) {
	int pv = v * 100 / max_v;
	int pa = a * 100 / max_a;
//	cout << pv << " " << pa << endl;//
	cout << endl << endl << endl << endl << endl << endl;
	line("v: ", pv);
	line("a: ", pa);
	printf("t: %5.3f   v: %5.3f   a: %5.3f\n", (float)t, (float)v, (float)a);
	out << t << "," << v << "," << a << endl;
}

LD f1(LD k) {
	return 1/(log2((LD)k/2+1.5));
}
LD f2(LD k) {
	return pow(2, 0.04*k) - 1;
}

int main() {
	
	out.open("out1.csv");
	out << "t,v,a\n";
	k = 1;
	v = 0;
	t = 0;
	int cnt = 60;
	cnt *= 20;
	while (cnt--) {
		LD a1 = k1 * mv * F_max * p1 * f1(k);
		LD a2 = -k2 * mv * f2(v/k);
		LD a3 = -k3 * mv * f_max * p2;
		LD a4 = -k4 * v;
//		cout << a1 << endl << a2 << endl << a3 << endl << a4 << endl;//
		LD a = a1 + a2 + a3;
		print(t, v, a);
		v += a/20;
		t += 0.05;
//		Sleep(50);
	}
	out.close();
}
