import java.util.*;

class Solution {
    // Maps a variable to its parent variable
    private Map<String, String> parent = new HashMap<>();
    // Maps a variable to its relative weight to its parent (node / parent = weight)
    private Map<String, Double> weight = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Step 1: Initialize the DSU and process all equations
        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            
            // If we haven't seen these variables before, point them to themselves
            if (!parent.containsKey(dividend)) {
                parent.put(dividend, dividend);
                weight.put(dividend, 1.0);
            }
            if (!parent.containsKey(divisor)) {
                parent.put(divisor, divisor);
                weight.put(divisor, 1.0);
            }
            
            // Link the sets
            union(dividend, divisor, values[i]);
        }

        // Step 2: Evaluate queries
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            if (!parent.containsKey(dividend) || !parent.containsKey(divisor)) {
                results[i] = -1.0;
            } else {
                String rootDividend = find(dividend);
                String rootDivisor = find(divisor);

                // If they share the same root, they are connected and we can find the ratio
                if (rootDividend.equals(rootDivisor)) {
                    results[i] = weight.get(dividend) / weight.get(divisor);
                } else {
                    results[i] = -1.0; // Unreachable
                }
            }
        }

        return results;
    }

    // Find the root of the variable and compress the path
    private String find(String s) {
        if (!parent.get(s).equals(s)) {
            String oldParent = parent.get(s);
            // Recursively find the absolute root
            String root = find(oldParent);
            
            // Path compression: point directly to the root
            parent.put(s, root);
            // Update the weight to be relative to the absolute root
            weight.put(s, weight.get(s) * weight.get(oldParent));
        }
        return parent.get(s);
    }

    // Connect two roots based on the given equation
    private void union(String dividend, String divisor, double value) {
        String rootDividend = find(dividend);
        String rootDivisor = find(divisor);

        if (!rootDividend.equals(rootDivisor)) {
            // Attach the root of the dividend to the root of the divisor
            parent.put(rootDividend, rootDivisor);
            
            // Calculate the correct weight ratio for the newly attached root
            // Formula derived from: (weight[dividend] * rootDividend) / (weight[divisor] * rootDivisor) = value
            double newWeight = (value * weight.get(divisor)) / weight.get(dividend);
            weight.put(rootDividend, newWeight);
        }
    }
}