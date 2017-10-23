/*L223. Rectangle Area
Find the total area covered by two rectilinear rectangles in a 2D plane.
Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
See image : https://leetcode.com/problems/rectangle-area/description/
*/
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int firstArea = (C - A)*(D - B);
        int secondArea = (G - E)*(H - F);
        // without overlap 
        //x direction
        if(C <= E || G <= A) return firstArea + secondArea;
        //y direction
        if(D <= F || H <= B) return firstArea + secondArea;
        
        // overlap part
        int bottom = Math.max(B, F);
        int top = Math.min(H, D);
        int left = Math.max(A, E);
        int right = Math.min(G, C);
        return firstArea + secondArea - (right - left)*(top - bottom);
    }
}
