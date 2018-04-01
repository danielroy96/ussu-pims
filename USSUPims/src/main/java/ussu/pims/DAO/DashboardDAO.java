/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ussu.pims.Mapper.ChartDataPointMapper;
import ussu.pims.Model.ChartDataPoint;

/**
 *
 * @author danielroy
 */
@Repository
public class DashboardDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ChartDataPoint> getAllTests7Days(int userId) {
        String SQL = ""
                + "SELECT\n"
                + "	all_tests.number_of_tests value\n"
                + ",	my_tests.my_number_of_tests my_value\n"
                + ", 	all_tests.test_date label\n"
                + "FROM (\n"
                + "	SELECT\n"
                + "		COUNT(*) number_of_tests\n"
                + ",  	DATE(NOW() - INTERVAL 6 DAY) test_date\n"
                + "	FROM pims.tests t\n"
                + "	WHERE DATE(t.test_datetime) = DATE(NOW() - INTERVAL 6 DAY)\n"
                + ") all_tests\n"
                + "JOIN (\n"
                + "	SELECT\n"
                + "		COUNT(*) my_number_of_tests\n"
                + "	, 	DATE(NOW() - INTERVAL 6 DAY) test_date\n"
                + "    FROM pims.tests t\n"
                + "    WHERE DATE(t.test_datetime) = DATE(NOW() - INTERVAL 6 DAY)\n"
                + "    AND t.test_user = ?\n"
                + ") my_tests ON all_tests.test_date = my_tests.test_date\n"
                + "UNION\n"
                + "SELECT\n"
                + "	all_tests.number_of_tests value\n"
                + ",	my_tests.my_number_of_tests my_value\n"
                + ", 	all_tests.test_date label\n"
                + "FROM (\n"
                + "	SELECT\n"
                + "		COUNT(*) number_of_tests\n"
                + ",  	DATE(NOW() - INTERVAL 5 DAY) test_date\n"
                + "	FROM pims.tests t\n"
                + "	WHERE DATE(t.test_datetime) = DATE(NOW() - INTERVAL 5 DAY)\n"
                + ") all_tests\n"
                + "JOIN (\n"
                + "	SELECT\n"
                + "		COUNT(*) my_number_of_tests\n"
                + "	, 	DATE(NOW() - INTERVAL 5 DAY) test_date\n"
                + "    FROM pims.tests t\n"
                + "    WHERE DATE(t.test_datetime) = DATE(NOW() - INTERVAL 5 DAY)\n"
                + "    AND t.test_user = ?\n"
                + ") my_tests ON all_tests.test_date = my_tests.test_date\n"
                + "UNION\n"
                + "SELECT\n"
                + "	all_tests.number_of_tests value\n"
                + ",	my_tests.my_number_of_tests my_value\n"
                + ", 	all_tests.test_date label\n"
                + "FROM (\n"
                + "	SELECT\n"
                + "		COUNT(*) number_of_tests\n"
                + ",  	DATE(NOW() - INTERVAL 4 DAY) test_date\n"
                + "	FROM pims.tests t\n"
                + "	WHERE DATE(t.test_datetime) = DATE(NOW() - INTERVAL 4 DAY)\n"
                + ") all_tests\n"
                + "JOIN (\n"
                + "	SELECT\n"
                + "		COUNT(*) my_number_of_tests\n"
                + "	, 	DATE(NOW() - INTERVAL 4 DAY) test_date\n"
                + "    FROM pims.tests t\n"
                + "    WHERE DATE(t.test_datetime) = DATE(NOW() - INTERVAL 4 DAY)\n"
                + "    AND t.test_user = ?\n"
                + ") my_tests ON all_tests.test_date = my_tests.test_date\n"
                + "UNION\n"
                + "SELECT\n"
                + "	all_tests.number_of_tests value\n"
                + ",	my_tests.my_number_of_tests my_value\n"
                + ", 	all_tests.test_date label\n"
                + "FROM (\n"
                + "	SELECT\n"
                + "		COUNT(*) number_of_tests\n"
                + ",  	DATE(NOW() - INTERVAL 3 DAY) test_date\n"
                + "	FROM pims.tests t\n"
                + "	WHERE DATE(t.test_datetime) = DATE(NOW() - INTERVAL 3 DAY)\n"
                + ") all_tests\n"
                + "JOIN (\n"
                + "	SELECT\n"
                + "		COUNT(*) my_number_of_tests\n"
                + "	, 	DATE(NOW() - INTERVAL 3 DAY) test_date\n"
                + "    FROM pims.tests t\n"
                + "    WHERE DATE(t.test_datetime) = DATE(NOW() - INTERVAL 3 DAY)\n"
                + "    AND t.test_user = ?\n"
                + ") my_tests ON all_tests.test_date = my_tests.test_date\n"
                + "UNION\n"
                + "SELECT\n"
                + "	all_tests.number_of_tests value\n"
                + ",	my_tests.my_number_of_tests my_value\n"
                + ", 	all_tests.test_date label\n"
                + "FROM (\n"
                + "	SELECT\n"
                + "		COUNT(*) number_of_tests\n"
                + ",  	DATE(NOW() - INTERVAL 2 DAY) test_date\n"
                + "	FROM pims.tests t\n"
                + "	WHERE DATE(t.test_datetime) = DATE(NOW() - INTERVAL 2 DAY)\n"
                + ") all_tests\n"
                + "JOIN (\n"
                + "	SELECT\n"
                + "		COUNT(*) my_number_of_tests\n"
                + "	, 	DATE(NOW() - INTERVAL 2 DAY) test_date\n"
                + "    FROM pims.tests t\n"
                + "    WHERE DATE(t.test_datetime) = DATE(NOW() - INTERVAL 2 DAY)\n"
                + "    AND t.test_user = ?\n"
                + ") my_tests ON all_tests.test_date = my_tests.test_date\n"
                + "UNION\n"
                + "SELECT\n"
                + "	all_tests.number_of_tests value\n"
                + ",	my_tests.my_number_of_tests my_value\n"
                + ", 	all_tests.test_date label\n"
                + "FROM (\n"
                + "	SELECT\n"
                + "		COUNT(*) number_of_tests\n"
                + ",  	DATE(NOW() - INTERVAL 1 DAY) test_date\n"
                + "	FROM pims.tests t\n"
                + "	WHERE DATE(t.test_datetime) = DATE(NOW() - INTERVAL 1 DAY)\n"
                + ") all_tests\n"
                + "JOIN (\n"
                + "	SELECT\n"
                + "		COUNT(*) my_number_of_tests\n"
                + "	, 	DATE(NOW() - INTERVAL 1 DAY) test_date\n"
                + "    FROM pims.tests t\n"
                + "    WHERE DATE(t.test_datetime) = DATE(NOW() - INTERVAL 1 DAY)\n"
                + "    AND t.test_user = ?\n"
                + ") my_tests ON all_tests.test_date = my_tests.test_date\n"
                + "UNION\n"
                + "SELECT\n"
                + "	all_tests.number_of_tests value\n"
                + ",	my_tests.my_number_of_tests my_value\n"
                + ", 	all_tests.test_date label\n"
                + "FROM (\n"
                + "	SELECT\n"
                + "		COUNT(*) number_of_tests\n"
                + ",  	DATE(NOW() - INTERVAL 0 DAY) test_date\n"
                + "	FROM pims.tests t\n"
                + "	WHERE DATE(t.test_datetime) = DATE(NOW() - INTERVAL 0 DAY)\n"
                + ") all_tests\n"
                + "JOIN (\n"
                + "	SELECT\n"
                + "		COUNT(*) my_number_of_tests\n"
                + "	, 	DATE(NOW() - INTERVAL 0 DAY) test_date\n"
                + "    FROM pims.tests t\n"
                + "    WHERE DATE(t.test_datetime) = DATE(NOW() - INTERVAL 0 DAY)\n"
                + "    AND t.test_user = ?\n"
                + ") my_tests ON all_tests.test_date = my_tests.test_date";
        return jdbcTemplate.query(SQL, new ChartDataPointMapper(), userId, userId, userId, userId, userId, userId, userId);
    }

}