package com.lp.mvp_network.second2demo.bean;

import java.util.List;

/**
 * File descripition:
 *
 * @author lp
 * @date 2019/6/6
 */

public class Bean1 {

    /**
     * id : 6
     * type : 2
     * station_id : 1
     * datatime : 1559491200000
     * factors : [{"id":11,"history_id":6,"station_id":1,"factor_id":6,"datatime":1559491200000,"value_check":2.225,"value_span":5,"value_standard":4,"error_difference":-1.775,"error_percent":-44.38,"accept":false},{"id":12,"history_id":6,"station_id":1,"factor_id":7,"datatime":1559491200000,"value_check":1.595,"value_span":0.5,"value_standard":1.6,"error_difference":-0.005,"error_percent":-0.31,"accept":true},{"id":13,"history_id":6,"station_id":1,"factor_id":8,"datatime":1559491200000,"value_check":8.104,"value_span":20,"value_standard":8,"error_difference":0.104,"error_percent":1.3,"accept":true},null]
     */

    private int id;
    private int type;
    private int station_id;
    private long datatime;
    private List<FactorsBean> factors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public long getDatatime() {
        return datatime;
    }

    public void setDatatime(long datatime) {
        this.datatime = datatime;
    }

    public List<FactorsBean> getFactors() {
        return factors;
    }

    public void setFactors(List<FactorsBean> factors) {
        this.factors = factors;
    }

    public static class FactorsBean {
        /**
         * id : 11
         * history_id : 6
         * station_id : 1
         * factor_id : 6
         * datatime : 1559491200000
         * value_check : 2.225
         * value_span : 5.0
         * value_standard : 4.0
         * error_difference : -1.775
         * error_percent : -44.38
         * accept : false
         */

        private int id;
        private int history_id;
        private int station_id;
        private int factor_id;
        private long datatime;
        private double value_check;
        private double value_span;
        private double value_standard;
        private double error_difference;
        private double error_percent;
        private boolean accept;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getHistory_id() {
            return history_id;
        }

        public void setHistory_id(int history_id) {
            this.history_id = history_id;
        }

        public int getStation_id() {
            return station_id;
        }

        public void setStation_id(int station_id) {
            this.station_id = station_id;
        }

        public int getFactor_id() {
            return factor_id;
        }

        public void setFactor_id(int factor_id) {
            this.factor_id = factor_id;
        }

        public long getDatatime() {
            return datatime;
        }

        public void setDatatime(long datatime) {
            this.datatime = datatime;
        }

        public double getValue_check() {
            return value_check;
        }

        public void setValue_check(double value_check) {
            this.value_check = value_check;
        }

        public double getValue_span() {
            return value_span;
        }

        public void setValue_span(double value_span) {
            this.value_span = value_span;
        }

        public double getValue_standard() {
            return value_standard;
        }

        public void setValue_standard(double value_standard) {
            this.value_standard = value_standard;
        }

        public double getError_difference() {
            return error_difference;
        }

        public void setError_difference(double error_difference) {
            this.error_difference = error_difference;
        }

        public double getError_percent() {
            return error_percent;
        }

        public void setError_percent(double error_percent) {
            this.error_percent = error_percent;
        }

        public boolean isAccept() {
            return accept;
        }

        public void setAccept(boolean accept) {
            this.accept = accept;
        }
    }
}
