/*
Let’s say we have a website and we keep track of what pages customers are viewing, for things like business metrics.
Every time somebody comes to the website, we write a record to a log file consisting of Timestamp, PageId, CustomerId. 
At the end of the day we have a big log file with many entries in that format. And for every day we have a new file.
Now, given two log files (log file from day 1 and log file from day 2) we want to generate a list of ‘loyal customers’ 
that meet the criteria of: (a) they came on both days, and (b) they visited at least two unique pages.
*/

public class LoyalCustomerFinder {

    public Set<String> findLoyalCustomers(String logDataDay1, String logDataDay2) {
        Map<String, Set<String>> customerPagesDay1 = parseLogData(logDataDay1);
        Map<String, Set<String>> customerPagesDay2 = parseLogData(logDataDay2);

        Set<String> loyalCustomers = new HashSet<>();
        for (String customerId : customerPagesDay1.keySet()) {
            if (customerPagesDay2.containsKey(customerId)) {
                Set<String> uniquePagesDay1 = customerPagesDay1.get(customerId);
                Set<String> uniquePagesDay2 = customerPagesDay2.get(customerId);

                if (uniquePagesDay1.size() >= 2 && uniquePagesDay2.size() >= 2) {
                    loyalCustomers.add(customerId);
                }
            }
        }

        return loyalCustomers;
    }

    private Map<String, Set<String>> parseLogData(String logData) {
        Map<String, Set<String>> customerPages = new HashMap<>();
        String[] lines = logData.split("\n");
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String pageId = parts[1].trim();
                String customerId = parts[2].trim();

                customerPages.computeIfAbsent(customerId, k -> new HashSet<>()).add(pageId);
            }
        }
        return customerPages;
    }
}

public class LoyalCustomerFinderTest {

    @Test
    public void testFindLoyalCustomers() {
        String logDataDay1 = "2024-07-01T10:00:00, Page1, Customer1\n" +
                             "2024-07-01T10:05:00, Page2, Customer1\n" +
                             "2024-07-01T10:10:00, Page3, Customer2\n" +
                             "2024-07-01T10:15:00, Page1, Customer2\n" +
                             "2024-07-01T10:20:00, Page1, Customer3";

        String logDataDay2 = "2024-07-02T10:00:00, Page1, Customer1\n" +
                             "2024-07-02T10:05:00, Page2, Customer1\n" +
                             "2024-07-02T10:10:00, Page4, Customer2\n" +
                             "2024-07-02T10:15:00, Page5, Customer2\n" +
                             "2024-07-02T10:20:00, Page1, Customer3";

        LoyalCustomerFinder finder = new LoyalCustomerFinder();
        Set<String> loyalCustomers = finder.findLoyalCustomers(logDataDay1, logDataDay2);

        assertEquals(Set.of("Customer1", "Customer2"), loyalCustomers);
    }
}


