public class UnionFind {
  int parent[];
  int height[];

  public UnionFind(int n) {
    parent = new int[n];
    height = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = -1;
      height[i] = 0;
    }
  }
  public int findRep(int p) {
    int rep = p;
    while (parent[rep] != -1) {
      rep = parent[rep];
    }
   while (parent[p] != -1) {
      int temp = parent[p];
      parent[p] = rep;
      p = temp;
    }
    return rep;
  }
  public boolean isSameBag(int p, int q) {
    return findRep(p) == findRep(q);
  }

  public void mergeBags(int p, int q) {
    int pRep = findRep(p);
    int qRep = findRep(q);
    if (height[pRep] > height[qRep]) {
      parent[qRep] = pRep;
    } else if (height[pRep] < height[qRep]) {
      parent[pRep] = qRep;
    } else {
      parent[qRep] = pRep;
      height[pRep]++;
    }
  }
}
