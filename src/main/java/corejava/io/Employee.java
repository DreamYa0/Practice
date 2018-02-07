package corejava.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dreamyao
 * @title
 * @date 2018/2/4 下午4:06
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String name;
    private Double salary;
    private Integer year;
    private Integer month;
    private Integer day;
}
