<?php

header('Content-Type: application/json');
header("Access-Control-Allow-Origin: *");

$host     = "localhost";
$user     = "root";
$password = "";
$database = "company";

$conn = new mysqli($host, $user, $password, $database);
if ($conn->connect_error) {
    die(json_encode(['error' => 'Database connection failed']));
}

$action = $_GET['action'] ?? '';
$rows   = [];
if ($action == 'get_company_list') {
    $num   = 0;
    $query = "SELECT b.company_id as comId,
                b.id as branch_id,
                SUM(total_pos) as totalPos,
                c.company_name,
                COUNT(d.id) as totalDevices
                FROM branch_master as b
                INNER JOIN company_master as c
                ON b.company_id = c.id
                LEFT JOIN device_master as d
                ON b.id = d.branch_id
                GROUP BY b.company_id";
    $result = $conn->query($query);
    while ($row = $result->fetch_assoc()) {
        $id           = $row['comId'];
        $branch_id    = $row['branch_id'];
        $totalCount   = "SELECT COUNT(company_id) as total_count FROM branch_master WHERE company_id = '$id'";
        $result_count = $conn->query($totalCount);

        while ($total_count = $result_count->fetch_assoc()) {
            $row['total_count'] = $total_count["total_count"];

        }
        $total_sum = "SELECT SUM(purchase_1) as purchase_1, SUM(purchase_2) as purchase_2, SUM(purchase_3) as purchase_3, company_master.id as company_id, branch_master.company_id as foreign_company, device_master.deviceAmountID as device_id,
        SUM(device_amount.sales_1) as sales_1, SUM(device_amount.sales_2) as sales_2, SUM(device_amount.sales_3) as sales_3 FROM branch_purchase INNER JOIN branch_master ON branch_master.id = branch_purchase.branch_id INNER JOIN company_master ON company_master.id = branch_master.company_id INNER JOIN device_master ON device_master.branch_id = branch_master.id INNER JOIN device_amount ON device_amount.id = device_master.deviceAmountID WHERE company_master.id = '$id'";
        $total_sum_result = $conn->query($total_sum);

        while ($sum_of_total = $total_sum_result->fetch_assoc()) {
            $row['sales_1'] = $sum_of_total["sales_1"] == null ? 0 : $sum_of_total["sales_1"];
            $row['sales_2'] = $sum_of_total["sales_2"] == null ? 0 : $sum_of_total["sales_2"];
            $row['sales_3'] = $sum_of_total["sales_3"] == null ? 0 : $sum_of_total["sales_3"];

        }
        $purchase_query  = "SELECT SUM(purchase_1) as purchase_1, SUM(purchase_2) as purchase_2, SUM(purchase_3) as purchase_3 FROM branch_purchase INNER JOIN branch_master ON branch_master.id = branch_purchase.branch_id INNER JOIN company_master ON company_master.id = branch_master.company_id WHERE branch_master.company_id = '$id'";
        $result_purchase = $conn->query($purchase_query);
        while ($total_purchase = $result_purchase->fetch_assoc()) {
            $row['purchase_1'] = $total_purchase["purchase_1"] == null ? "₱ 0.00" : "₱ " . number_format($total_purchase["purchase_1"] ?? 0, 2, '.', ',');
            $row['purchase_2'] = $total_purchase["purchase_2"] == null ? "₱ 0.00" : "₱ " . number_format($total_purchase["purchase_2"] ?? 0, 2, '.', ',');
            $row['purchase_3'] = $total_purchase["purchase_3"] == null ? "₱ 0.00" : "₱ " . number_format($total_purchase["purchase_3"] ?? 0, 2, '.', ',');
        }
        $rows[] = $row;
    }
} else if ($action == 'get_branch') {
    $amount_id  = "";
    $company_id = $_GET["company_id"];
    $query      = "SELECT
                    b.id,
                    b.branch_name,
                    b.avg_sales as avg_sales,
                    c.company_name, branch_target.target_no as target_no,
                    branch_target.id as branch_target_id
                    FROM branch_master as b
                    INNER JOIN branch_target
                    ON branch_target.id = b.target_id
                    INNER JOIN company_master as c
                    ON b.company_id = c.id
                    WHERE b.company_id = '$company_id'";
    $result = $conn->query($query);
    while ($row = $result->fetch_assoc()) {
        $id        = $row["id"];
        $sumAmount = "SELECT Sum(amount.amount) as total,
         master.deviceAmountID,
         Count(master.id) as id, amount.id as amount_id
         FROM device_master as master
         INNER JOIN device_Amount as amount
         ON amount.id =  master.deviceAmountID
         WHERE branch_id = '$id'";
        $result_count = $conn->query($sumAmount);
        while ($total_count = $result_count->fetch_assoc()) {
            $row['total_amount'] = $total_count["total"] === null ? 0 : $total_count["total"];
            $row['total_device'] = $total_count["id"] === null ? 0 : $total_count["id"];
            $amount_id           = $total_count["amount_id"];
            //   $row['total_sales1'] = $total_count["total_sales1"];
        }
        $totalSales = "SELECT Sum(amount.sales_1) as total_sales1,Sum(amount.sales_2) as total_sales2, Sum(amount.sales_3) as total_sales3 FROM device_master INNER JOIN device_Amount as amount
         ON amount.id =  device_master.deviceAmountID WHERE device_master.branch_id = '$id'";
        $total_sales1 = $conn->query($totalSales);
        while ($total_count = $total_sales1->fetch_assoc()) {
            $row['total_sales1'] = $total_count["total_sales1"] == null ? "₱ 0.00" : "₱ " . number_format($total_count["total_sales1"] ?? 0, 2, '.', ',');
            $row['total_sales2'] = $total_count["total_sales2"] == null ? "₱ 0.00" : "₱ " . number_format($total_count["total_sales2"] ?? 0, 2, '.', ',');
            $row['total_sales3'] = $total_count["total_sales3"] == null ? "₱ 0.00" : "₱ " . number_format($total_count["total_sales3"] ?? 0, 2, '.', ',');
        }
        $purchase_query  = "SELECT SUM(purchase_1) as purchase_1, SUM(purchase_2) as purchase_2, SUM(purchase_3) as purchase_3 FROM branch_purchase WHERE branch_id = '$id'";
        $result_purchase = $conn->query($purchase_query);
        while ($total_purchase = $result_purchase->fetch_assoc()) {
            $row['purchase_1'] = $total_purchase["purchase_1"] == null ? "₱ 0.00" : "₱ " . number_format($total_purchase["purchase_1"] ?? 0, 2, '.', ',');
            $row['purchase_2'] = $total_purchase["purchase_2"] == null ? "₱ 0.00" : "₱ " . number_format($total_purchase["purchase_2"] ?? 0, 2, '.', ',');
            $row['purchase_3'] = $total_purchase["purchase_3"] == null ? "₱ 0.00" : "₱ " . number_format($total_purchase["purchase_3"] ?? 0, 2, '.', ',');
        }
        $rows[] = $row;
    }
} else if ($action == 'get_device') {
    $branch_id = $_GET["id"];
    $limit     = isset($_GET["limit"]) ? (int) $_GET["limit"] : 5;
    $page      = isset($_GET["page"]) ? (int) $_GET["page"] : 1;
    $num       = 1;

    $offset = ($page - 1) * $limit;
    $query  = "SELECT master.id as num,
                master.branch_id as id,
                amount.sales_1 as sales1,
                amount.sales_2 as sales2,
                amount.sales_3 as sales3,
                amount.amount as amount,
                branch.branch_name as branchName,
                branch.company_id as comId,
                company.company_name as comName,
                master.deviceAmountID as amountID,
                master.serial_num as serial
                FROM device_master as master
                INNER JOIN device_amount as amount
                ON amount.id = master.deviceAmountID
                INNER JOIN branch_master as branch
                ON master.branch_id = branch.id
                INNER JOIN company_master as company
                ON company.id = branch.company_id
                WHERE branch_id = '$branch_id'
                LIMIT $limit OFFSET $offset";
    $result = $conn->query($query);
    while ($row = $result->fetch_assoc()) {
        $branch_id       = $row['id'];
        $row['sales1']   = "₱" . number_format($row['sales1'] ?? 0, 2, '.', ',');
        $row['sales2']   = "₱" . number_format($row['sales2'] ?? 0, 2, '.', ',');
        $row['sales3']   = "₱" . number_format($row['sales3'] ?? 0, 2, '.', ',');
        $getTotalDevices = "SELECT Count(id) as totalDevices
        FROM device_master
        WHERE branch_id = '$branch_id'";
        $result2 = $conn->query($getTotalDevices);
        while ($totalDevices = $result2->fetch_assoc()) {
            $row['totalDevices'] = $totalDevices['totalDevices'];
        }
        $rows[] = $row;
    }

} else if ($action == 'target_update') {
    $id     = $_GET["id"];
    $target = $_GET["value"];
    $update = "UPDATE branch_target SET target_no = '$target' WHERE id = '$id'";
    $result = $conn->query($update);
} else {
    echo json_encode(['error' => 'Invalid action']);
}

echo json_encode($rows);
// $rows            = [];
//     $total_avg_sales = 0;
//     $query           = "SELECT  id, company_name FROM company_master";
//     $result          = $conn->query($query);

//     while ($row = $result->fetch_assoc()) {
//         $row['database'] = $database;
//         $total_sales     = 0;
//         $total_pos       = 0;
//         $company_id      = $row["id"];
//         $query_total     = "SELECT * FROM branch_master WHERE company_id = '$company_id'";
//         $result_total    = $conn->query($query_total);
//         $num             = 0;
//         while ($total = $result_total->fetch_assoc()) {
//             $total_sales += $total["avg_sales"];
//             $total_pos += $total["total_pos"];
//             $row['number'] = $num += 1;
//         }
//         $count        = "SELECT COUNT(company_id) as total FROM branch_master WHERE company_id = '$company_id'";
//         $result_count = $conn->query($count);
//         while ($total_count = $result_count->fetch_assoc()) {
//             $row['total_count'] = $total_count["total"];
//         }

//         $row['total_avg_sales'] = $num === 0 ? $total_sales : $total_sales / $num;
//         $row['total_pos']       = $num === 0 ? $total_pos : number_format($total_pos, 0, '', '');
//         $row['total__avg_pos']  = $num === 0 ? $total_pos : number_format($total_pos / $num, 0, '', '');
//         $rows[]                 = $row;
//     }
