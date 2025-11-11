import java.io.*;

public class FileHandling {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\Darwin John\\OneDrive\\Documents\\inventory.txt";
        String reportFile = "C:\\Users\\Darwin John\\OneDrive\\Documents\\LowStock";

        try {
            new FileWriter(reportFile, false).close();

            System.out.println("Using Character Stream");
            checkChar(inputFile, reportFile);

            System.out.println("Using Byte Stream");
            checkByte(inputFile, reportFile);

            System.out.println("Report saved in " + reportFile);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void checkChar(String inputFile, String reportFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(reportFile, true));

            bw.write("Low Stock Alert (Character Stream)\n");
            bw.write("Product\tStock\tPrice\n");

            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length != 3) continue;

                String name = parts[0].trim();
                int stock = Integer.parseInt(parts[1].trim());
                double price = Double.parseDouble(parts[2].trim());

                if (stock < 5) {
                    found = true;
                    bw.write(name + "\t" + stock + "\t" + price + "\n");
                }
            }

            if (!found) {
                bw.write("All products have enough stock.\n");
            }

            br.close();
            bw.close();
        } catch (IOException e) {
            System.out.println("Char Stream Error: " + e.getMessage());
        }
    }

    public static void checkByte(String inputFile, String reportFile) {
        try {
            FileInputStream fis = new FileInputStream(inputFile);
            FileOutputStream fos = new FileOutputStream(reportFile, true);

            StringBuilder sb = new StringBuilder();
            int b;
            while ((b = fis.read()) != -1) {
                sb.append((char) b);
            }

            String[] lines = sb.toString().split("\n");
            StringBuilder report = new StringBuilder();
            report.append("Low Stock Alert (Byte Stream)\n");
            report.append("Product\tStock\tPrice\n");

            boolean found = false;
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length != 3) continue;

                String name = parts[0].trim();
                int stock = Integer.parseInt(parts[1].trim());
                double price = Double.parseDouble(parts[2].trim());

                if (stock < 5) {
                    found = true;
                    report.append(name + "\t" + stock + "\t" + price + "\n");
                }
            }

            if (!found) {
                report.append("All products have enough stock.\n");
            }

            fos.write(report.toString().getBytes());
            fis.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Byte Stream Error: " + e.getMessage());
        }
    }
}