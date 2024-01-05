public class lab4
{
    private double[] vector = null;
    public lab4(double[] vector){
        this.vector = vector;
    }
    public double sum(lab4 anotherVector)
    {
        double s = 0;
        for (int i = 0; i < vector.length; i++)
        {
            s += vector[i] * anotherVector.vector[i];
        }
        return s;
    }
    public lab4 add(lab4 anotherVector)
    {
        double[] result = new double[vector.length];
        for (int i = 0; i < vector.length; i++)
        {
            result[i] = vector[i] + anotherVector.vector[i];
        }
        return new lab4(result);
    }
    public lab4 sub(lab4 anotherVector)
    {
        double[] result = new double[vector.length];
        for (int i = 0; i < vector.length; i++)
        {
            result[i] = vector[i] - anotherVector.vector[i];
        }
        return new lab4(result);
    }
    public lab4 multiply(double scalar)
    {
        double[] result = new double[vector.length];
        for (int i = 0; i < vector.length; i++)
        {
            result[i] = vector[i] * scalar;
        }
        return new lab4(result);
    }
    public static double sum(lab4 a, lab4 b){
        return a.sum(b);
    }
    public static lab4 add(lab4 a, lab4 b){
        return a.add(b);
    }
    public static lab4 sub(lab4 a, lab4 b){
        return a.sub(b);
    }
    public static lab4 multiply(lab4 a, double scalar){
        return a.multiply(scalar);
    }
    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < vector.length; i++)
        {
            result.append(vector[i]);
            if (i != vector.length - 1)
            {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
    public static void main(String[] args)
    {
        double[] a = {1, 2, 3, 4};
        double[] b = {1, 1, 1, 1};
        double[] c = {2, 2, 2, 2};
        lab4 v1 = new lab4(a);
        lab4 v2 = new lab4(b);
        lab4 v3 = new lab4(c);
        System.out.println("v1 * v2 = " + v1.sum(v2));
        System.out.println("v1 * v2 = " + lab4.sum(v1, v2));
        System.out.println("v1 + v3 = " + lab4.add(v1, v3).toString());
        System.out.println("v1 - v3 = " + lab4.sub(v1, v3).toString());
        System.out.println("v1 * 2 = " + lab4.multiply(v1, 2).toString());
    }
}