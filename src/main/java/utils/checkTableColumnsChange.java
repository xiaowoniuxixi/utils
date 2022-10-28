package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Delta Lake schema 变更检测工具（差集）
 * @author hzzhou
 * @since 2022-10-28
 */
public class checkTableColumnsChange {
    public static void main(String[] args) {
        test_1();
    }

    private static void test_1() {
        String tableSchema ="-- pre_name: string (nullable = true)\n" +
                "-- seller_code: string (nullable = true)\n" +
                "-- goods_id: string (nullable = true)\n" +
                "-- goods_name: string (nullable = true)\n" +
                "-- is_popular: string (nullable = true)\n" +
                "-- main_rule: string (nullable = true)\n" +
                "-- main_position: string (nullable = true)\n" +
                "-- create_time: timestamp (nullable = true)\n" +
                "-- update_time: timestamp (nullable = true)\n" +
                "-- platform: string (nullable = true)\n" +
                "-- sub_brand: string (nullable = true)\n" +
                "-- sale_stat_type: string (nullable = true)\n" +
                "-- etl_create_time: timestamp (nullable = true)\n" +
                "-- etl_update_time: timestamp (nullable = true)\n" +
                "-- channel_name: string (nullable = true)\n" +
                "-- shop_name: string (nullable = true)\n" +
                "-- bus_model: string (nullable = true)\n" +
                "-- cate: string (nullable = true)\n" +
                "-- party_name: string (nullable = true)\n" +
                "-- brand_name: string (nullable = true)\n" +
                "-- cption_model: string (nullable = true)\n" +
                "-- predict_one_endtime: timestamp (nullable = true)\n" +
                "-- predict_ten_starttime: timestamp (nullable = true)\n" +
                "-- predict_eight_starttime: timestamp (nullable = true)\n" +
                "-- predict_nine_starttime: timestamp (nullable = true)\n" +
                "-- predict_four_starttime: timestamp (nullable = true)\n" +
                "-- predict_five_endtime: timestamp (nullable = true)\n" +
                "-- predict_three_starttime: timestamp (nullable = true)\n" +
                "-- predict_five_starttime: timestamp (nullable = true)\n" +
                "-- predict_seven_endtime: timestamp (nullable = true)\n" +
                "-- predict_two_starttime: timestamp (nullable = true)\n" +
                "-- predict_eight_endtime: timestamp (nullable = true)\n" +
                "-- predict_four_endtime: timestamp (nullable = true)\n" +
                "-- predict_six_starttime: timestamp (nullable = true)\n" +
                "-- predict_seven_starttime: timestamp (nullable = true)\n" +
                "-- predict_six_endtime: timestamp (nullable = true)\n" +
                "-- predict_one_starttime: timestamp (nullable = true)\n" +
                "-- predict_three_endtime: timestamp (nullable = true)\n" +
                "-- predict_ten_endtime: timestamp (nullable = true)\n" +
                "-- predict_nine_endtime: timestamp (nullable = true)\n" +
                "-- predict_two_endtime: timestamp (nullable = true)\n" +
                "-- sku_code: string (nullable = true)\n" +
                "-- id: long (nullable = true)\n" +
                "-- source_sys: integer (nullable = true)\n" +
                "-- source_id: long (nullable = true)\n" +
                "-- source_table: integer (nullable = true)\n" +
                "-- shop_id: long (nullable = true)\n" +
                "-- activity_price: decimal(20,4) (nullable = true)\n" +
                "-- sale_num: decimal(21,0) (nullable = true)\n" +
                "-- sale_amt: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_one: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_two: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_three: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_four: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_five: decimal(21,0) (nullable = true)\n" +
                "-- pre_amt_one: decimal(20,4) (nullable = true)\n" +
                "-- pre_amt_two: decimal(20,4) (nullable = true)\n" +
                "-- pre_amt_three: decimal(20,4) (nullable = true)\n" +
                "-- pre_amt_four: decimal(20,4) (nullable = true)\n" +
                "-- pre_amt_five: decimal(20,4) (nullable = true)\n" +
                "-- create_user: long (nullable = true)\n" +
                "-- update_user: long (nullable = true)\n" +
                "-- pre_num_six: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_seven: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_eight: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_nine: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_ten: decimal(21,0) (nullable = true)\n" +
                "-- pre_amt_six: decimal(20,4) (nullable = true)\n" +
                "-- pre_amt_seven: decimal(20,4) (nullable = true)\n" +
                "-- pre_amt_eight: decimal(20,4) (nullable = true)\n" +
                "-- pre_amt_nine: decimal(20,4) (nullable = true)\n" +
                "-- pre_amt_ten: decimal(20,4) (nullable = true)\n" +
                "-- is_del: integer (nullable = true)\n" +
                "-- channel_id: long (nullable = true)";
        String dataSchema = "-- pre_name: string (nullable = true)\n" +
                "-- seller_code: string (nullable = true)\n" +
                "-- goods_id: string (nullable = true)\n" +
                "-- goods_name: string (nullable = true)\n" +
                "-- is_popular: string (nullable = true)\n" +
                "-- main_rule: string (nullable = true)\n" +
                "-- main_position: string (nullable = true)\n" +
                "-- create_time: timestamp (nullable = true)\n" +
                "-- update_time: timestamp (nullable = true)\n" +
                "-- platform: string (nullable = true)\n" +
                "-- sub_brand: string (nullable = true)\n" +
                "-- sale_stat_type: string (nullable = true)\n" +
                "-- etl_create_time: timestamp (nullable = true)\n" +
                "-- etl_update_time: timestamp (nullable = true)\n" +
                "-- channel_name: string (nullable = true)\n" +
                "-- shop_name: string (nullable = true)\n" +
                "-- status: string (nullable = true)\n" +
                "-- bus_model: string (nullable = true)\n" +
                "-- cate: string (nullable = true)\n" +
                "-- party_name: string (nullable = true)\n" +
                "-- brand_name: string (nullable = true)\n" +
                "-- cption_model: string (nullable = true)\n" +
                "-- predict_one_endtime: timestamp (nullable = true)\n" +
                "-- predict_ten_starttime: timestamp (nullable = true)\n" +
                "-- predict_eight_starttime: timestamp (nullable = true)\n" +
                "-- predict_nine_starttime: timestamp (nullable = true)\n" +
                "-- predict_four_starttime: timestamp (nullable = true)\n" +
                "-- predict_five_endtime: timestamp (nullable = true)\n" +
                "-- predict_three_starttime: timestamp (nullable = true)\n" +
                "-- predict_five_starttime: timestamp (nullable = true)\n" +
                "-- predict_seven_endtime: timestamp (nullable = true)\n" +
                "-- predict_two_starttime: timestamp (nullable = true)\n" +
                "-- predict_eight_endtime: timestamp (nullable = true)\n" +
                "-- predict_four_endtime: timestamp (nullable = true)\n" +
                "-- predict_six_starttime: timestamp (nullable = true)\n" +
                "-- predict_seven_starttime: timestamp (nullable = true)\n" +
                "-- predict_six_endtime: timestamp (nullable = true)\n" +
                "-- predict_one_starttime: timestamp (nullable = true)\n" +
                "-- predict_three_endtime: timestamp (nullable = true)\n" +
                "-- predict_ten_endtime: timestamp (nullable = true)\n" +
                "-- predict_nine_endtime: timestamp (nullable = true)\n" +
                "-- predict_two_endtime: timestamp (nullable = true)\n" +
                "-- sku_code: string (nullable = true)\n" +
                "-- goods_no: string (nullable = true)\n" +
                "-- cate_refer: string (nullable = true)\n" +
                "-- cate_name: string (nullable = true)\n" +
                "-- id: long (nullable = true)\n" +
                "-- source_sys: integer (nullable = true)\n" +
                "-- source_id: long (nullable = true)\n" +
                "-- source_table: integer (nullable = true)\n" +
                "-- shop_id: long (nullable = true)\n" +
                "-- activity_price: decimal(20,4) (nullable = true)\n" +
                "-- sale_num: decimal(21,0) (nullable = true)\n" +
                "-- sale_amt: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_one: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_two: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_three: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_four: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_five: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_six: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_seven: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_eight: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_nine: decimal(21,0) (nullable = true)\n" +
                "-- pre_num_ten: decimal(21,0) (nullable = true)\n" +
                "-- pre_amt_one: decimal(20,4) (nullable = true)\n" +
                "-- pre_amt_two: decimal(20,4) (nullable = true)\n" +
                "-- pre_amt_three: decimal(20,4) (nullable = true)\n" +
                "-- pre_amt_four: decimal(20,4) (nullable = true)\n" +
                "-- pre_amt_five: decimal(20,4) (nullable = true)\n" +
                "-- pre_amt_six: decimal(20,4) (nullable = true)\n" +
                "-- pre_amt_seven: decimal(20,4) (nullable = true)\n" +
                "-- pre_amt_eight: decimal(20,4) (nullable = true)\n" +
                "-- pre_amt_nine: decimal(20,4) (nullable = true)\n" +
                "-- pre_amt_ten: decimal(20,4) (nullable = true)\n" +
                "-- create_user: long (nullable = true)\n" +
                "-- update_user: long (nullable = true)\n" +
                "-- is_del: integer (nullable = true)\n" +
                "-- channel_id: long (nullable = true)";

        List<String> tableColumns = Arrays.asList(tableSchema.split("--"));
        List<String> dataColumns = Arrays.asList(dataSchema.split("--"));
        List<String> left2Right = tableColumns.stream().filter(item -> !dataColumns.contains(item)).collect(toList());
        List<String> right2Left = dataColumns.stream().filter(item -> !tableColumns.contains(item)).collect(toList());
        System.out.println("tableColumns - dataColumns = \n" + left2Right.toString());
        System.out.println();
        System.out.println("dataColumns  - tableColumns = \n" + right2Left.toString());
    }
}
