package com.sise.mapper.providers;

import com.sise.entity.GoodsInfo;
import com.sise.entity.GoodsInfoExample;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class GoodsInfoSqlProvider {

    public String countByExample(GoodsInfoExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("goods_info");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(GoodsInfoExample example) {
        BEGIN();
        DELETE_FROM("goods_info");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(GoodsInfo record) {
        BEGIN();
        INSERT_INTO("goods_info");
        
        if (record.getSupplierName() != null) {
            VALUES("supplier_name", "#{supplierName,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsName() != null) {
            VALUES("goods_name", "#{goodsName,jdbcType=VARCHAR}");
        }
        
        if (record.getPayType() != null) {
            VALUES("pay_type", "#{payType,jdbcType=VARCHAR}");
        }
        
        if (record.getPurchaseTime() != null) {
            VALUES("purchase_time", "#{purchaseTime,jdbcType=VARCHAR}");
        }
        
        if (record.getQuantity() != null) {
            VALUES("quantity", "#{quantity,jdbcType=INTEGER}");
        }
        
        if (record.getTotalPrice() != null) {
            VALUES("total_price", "#{totalPrice,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getReturned() != null) {
            VALUES("returned", "#{returned,jdbcType=TINYINT}");
        }
        
        return SQL();
    }

    public String selectByExample(GoodsInfoExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("supplier_name");
        SELECT("goods_name");
        SELECT("pay_type");
        SELECT("purchase_time");
        SELECT("quantity");
        SELECT("total_price");
        SELECT("remark");
        SELECT("returned");
        FROM("goods_info");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        String sqlString = SQL();
        if (example != null && example.getLimit() != null) {
            sqlString += " limit " + example.getLimit();
        }
        if (example != null && example.getOffset() != null) {
            sqlString += " offset " + example.getOffset();
        }
        return sqlString;
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        GoodsInfo record = (GoodsInfo) parameter.get("record");
        GoodsInfoExample example = (GoodsInfoExample) parameter.get("example");
        
        BEGIN();
        UPDATE("goods_info");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getSupplierName() != null) {
            SET("supplier_name = #{record.supplierName,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsName() != null) {
            SET("goods_name = #{record.goodsName,jdbcType=VARCHAR}");
        }
        
        if (record.getPayType() != null) {
            SET("pay_type = #{record.payType,jdbcType=VARCHAR}");
        }
        
        if (record.getPurchaseTime() != null) {
            SET("purchase_time = #{record.purchaseTime,jdbcType=VARCHAR}");
        }
        
        if (record.getQuantity() != null) {
            SET("quantity = #{record.quantity,jdbcType=INTEGER}");
        }
        
        if (record.getTotalPrice() != null) {
            SET("total_price = #{record.totalPrice,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getReturned() != null) {
            SET("returned = #{record.returned,jdbcType=TINYINT}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("goods_info");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("supplier_name = #{record.supplierName,jdbcType=VARCHAR}");
        SET("goods_name = #{record.goodsName,jdbcType=VARCHAR}");
        SET("pay_type = #{record.payType,jdbcType=VARCHAR}");
        SET("purchase_time = #{record.purchaseTime,jdbcType=VARCHAR}");
        SET("quantity = #{record.quantity,jdbcType=INTEGER}");
        SET("total_price = #{record.totalPrice,jdbcType=INTEGER}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("returned = #{record.returned,jdbcType=TINYINT}");
        
        GoodsInfoExample example = (GoodsInfoExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(GoodsInfo record) {
        BEGIN();
        UPDATE("goods_info");
        
        if (record.getSupplierName() != null) {
            SET("supplier_name = #{supplierName,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsName() != null) {
            SET("goods_name = #{goodsName,jdbcType=VARCHAR}");
        }
        
        if (record.getPayType() != null) {
            SET("pay_type = #{payType,jdbcType=VARCHAR}");
        }
        
        if (record.getPurchaseTime() != null) {
            SET("purchase_time = #{purchaseTime,jdbcType=VARCHAR}");
        }
        
        if (record.getQuantity() != null) {
            SET("quantity = #{quantity,jdbcType=INTEGER}");
        }
        
        if (record.getTotalPrice() != null) {
            SET("total_price = #{totalPrice,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getReturned() != null) {
            SET("returned = #{returned,jdbcType=TINYINT}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(GoodsInfoExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<GoodsInfoExample.Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            GoodsInfoExample.Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<GoodsInfoExample.Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    GoodsInfoExample.Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}
