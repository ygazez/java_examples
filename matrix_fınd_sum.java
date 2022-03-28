class Main {
  static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
  
        return true;
    }

  public static void main(String[] args) {
    int dizi [][]=new int [][] {{1},
                                {8,4},
                                {2,6,9},
                                {8,5,9,3}};

    int i = 0;
    int j= 0;
    int sum = 0;
    int max = 0;
    int down = -1;
    int rDiagonal = -1;
    int lDiagonal = -1;
    while(i+1 != dizi.length) {
      if(!isPrime(dizi[0][0]) && i== 0 && j==0) {
        sum += dizi[0][0];
      }
      if(i-1 > 0) {
        if(!isPrime(dizi[i+1][j-1]) && i+1 != dizi.length && j <= dizi.length - 1) {
          lDiagonal = dizi[i+1][j-1];
        }  
      }
      if(!isPrime(dizi[i+1][j]) && i+1 <= dizi.length - 1 && j <= dizi.length - 1) {
        down = dizi[i+1][j];
      }
      if(!isPrime(dizi[i+1][j+1]) && i+1 <= dizi.length - 1 && j+1 <= dizi.length - 1)      {
        rDiagonal = dizi[i+1][j+1];
      }
      max = Math.max(Math.max(rDiagonal,lDiagonal),down);
      sum = sum + max;

      if(max == lDiagonal) {
        i= i+1;
        j= j-1;
      }
      else if(max == rDiagonal) {
        i= i+1;
        j= j+1;
      }
      else if(max == down) {
        i= i+1;
        j= j;
      }
    down = -1;
    rDiagonal = -1;
    lDiagonal = -1;
    }
    System.out.println(sum);
  }

}
