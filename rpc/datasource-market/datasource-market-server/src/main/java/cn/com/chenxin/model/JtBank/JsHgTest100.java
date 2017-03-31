package cn.com.chenxin.model.JtBank;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "JS_HG_TEST100")
public class JsHgTest100 {
    @Column(name = "INPUTE_DATE")
    private Date inputeDate;

    @Column(name = "ENT_NAME")
    private String entName;

    @Column(name = "ENT_CONTACT")
    private String entContact;

    @Column(name = "ENT_TEL")
    private String entTel;

    @Column(name = "CONSIGNOR_CODE")
    private String consignorCode;

    @Column(name = "CONSIGNOR_CNAME")
    private String consignorCname;

    @Column(name = "CONSIGNOR_ENAME")
    private String consignorEname;

    @Column(name = "CONSIGNEE_CODE")
    private String consigneeCode;

    @Column(name = "CONSIGNEE_CNAME")
    private String consigneeCname;

    @Column(name = "CONSIGNEE_ENAME")
    private String consigneeEname;

    @Column(name = "TRANS_TYPE_CODE")
    private String transTypeCode;

    @Column(name = "TRANS_TYPE_NAME")
    private String transTypeName;

    @Column(name = "GOODS_PLACE")
    private String goodsPlace;

    @Column(name = "TRADE_MODE_CODE")
    private String tradeModeCode;

    @Column(name = "TRADE_MODE_NAME")
    private String tradeModeName;

    @Column(name = "DESP_PORT_CODE")
    private String despPortCode;

    @Column(name = "DESP_PORT_NAME")
    private String despPortName;

    @Column(name = "ARRI_PORT_CODE")
    private String arriPortCode;

    @Column(name = "ARRI_PORT_NAME")
    private String arriPortName;

    @Column(name = "ENTRY_PORT_CODE")
    private String entryPortCode;

    @Column(name = "ENTRY_PORT_NAME")
    private String entryPortName;

    @Column(name = "DEST_CODE")
    private String destCode;

    @Column(name = "DEST_NAME")
    private String destName;

    @Column(name = "TRADE_COUNTRY_CODE")
    private String tradeCountryCode;

    @Column(name = "TRADE_COUNTRY_NAME")
    private String tradeCountryName;

    @Column(name = "DESP_COUNTRY_CODE")
    private String despCountryCode;

    @Column(name = "DESP_COUNTRY_NAME")
    private String despCountryName;

    @Column(name = "CONTRACT_NO")
    private String contractNo;

    @Column(name = "PROD_REG_NO")
    private String prodRegNo;

    @Column(name = "PROD_CNAME")
    private String prodCname;

    @Column(name = "PROD_CONTACT")
    private String prodContact;

    @Column(name = "PROD_TEL")
    private String prodTel;

    @Column(name = "HS_CODE")
    private String hsCode;

    @Column(name = "GOODS_CNAME")
    private String goodsCname;

    @Column(name = "GOODS_ENAME")
    private String goodsEname;

    @Column(name = "GOODS_MODEL")
    private String goodsModel;

    @Column(name = "ORIGIN_PLACE_CODE")
    private String originPlaceCode;

    @Column(name = "ORIGIN_PLACE_NAME")
    private String originPlaceName;

    @Column(name = "ORIGIN_COUNTRY_CODE")
    private String originCountryCode;

    @Column(name = "ORIGIN_COUNTRY_NAME")
    private String originCountryName;

    @Column(name = "QTY")
    private BigDecimal qty;

    @Column(name = "QTY_UNIT_CODE")
    private String qtyUnitCode;

    @Column(name = "QTY_UNIT_NAME")
    private String qtyUnitName;

    @Column(name = "WEIGHT")
    private BigDecimal weight;

    @Column(name = "WEIGHT_UNIT_CODE")
    private String weightUnitCode;

    @Column(name = "WEIGHT_UNIT_NAME")
    private String weightUnitName;

    @Column(name = "GOODS_UNIT_PRICE")
    private BigDecimal goodsUnitPrice;

    @Column(name = "GOODS_TOTAL_VALUES")
    private BigDecimal goodsTotalValues;

    @Column(name = "CURR_UNIT")
    private String currUnit;

    @Column(name = "CURR_UNIT_NAME")
    private String currUnitName;

    @Column(name = "PACK_NUMBER")
    private BigDecimal packNumber;

    @Column(name = "PACK_TYPE_CODE")
    private String packTypeCode;

    @Column(name = "PACK_TYPE_NAME")
    private String packTypeName;

    @Column(name = "STD_QUANTITY")
    private BigDecimal stdQuantity;

    @Column(name = "STD_UNIT_CODE")
    private String stdUnitCode;

    @Column(name = "STD_UNIT_NAME")
    private String stdUnitName;

    /**
     * @return INPUTE_DATE
     */
    public Date getInputeDate() {
        return inputeDate;
    }

    /**
     * @param inputeDate
     */
    public void setInputeDate(Date inputeDate) {
        this.inputeDate = inputeDate;
    }

    /**
     * @return ENT_NAME
     */
    public String getEntName() {
        return entName;
    }

    /**
     * @param entName
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * @return ENT_CONTACT
     */
    public String getEntContact() {
        return entContact;
    }

    /**
     * @param entContact
     */
    public void setEntContact(String entContact) {
        this.entContact = entContact;
    }

    /**
     * @return ENT_TEL
     */
    public String getEntTel() {
        return entTel;
    }

    /**
     * @param entTel
     */
    public void setEntTel(String entTel) {
        this.entTel = entTel;
    }

    /**
     * @return CONSIGNOR_CODE
     */
    public String getConsignorCode() {
        return consignorCode;
    }

    /**
     * @param consignorCode
     */
    public void setConsignorCode(String consignorCode) {
        this.consignorCode = consignorCode;
    }

    /**
     * @return CONSIGNOR_CNAME
     */
    public String getConsignorCname() {
        return consignorCname;
    }

    /**
     * @param consignorCname
     */
    public void setConsignorCname(String consignorCname) {
        this.consignorCname = consignorCname;
    }

    /**
     * @return CONSIGNOR_ENAME
     */
    public String getConsignorEname() {
        return consignorEname;
    }

    /**
     * @param consignorEname
     */
    public void setConsignorEname(String consignorEname) {
        this.consignorEname = consignorEname;
    }

    /**
     * @return CONSIGNEE_CODE
     */
    public String getConsigneeCode() {
        return consigneeCode;
    }

    /**
     * @param consigneeCode
     */
    public void setConsigneeCode(String consigneeCode) {
        this.consigneeCode = consigneeCode;
    }

    /**
     * @return CONSIGNEE_CNAME
     */
    public String getConsigneeCname() {
        return consigneeCname;
    }

    /**
     * @param consigneeCname
     */
    public void setConsigneeCname(String consigneeCname) {
        this.consigneeCname = consigneeCname;
    }

    /**
     * @return CONSIGNEE_ENAME
     */
    public String getConsigneeEname() {
        return consigneeEname;
    }

    /**
     * @param consigneeEname
     */
    public void setConsigneeEname(String consigneeEname) {
        this.consigneeEname = consigneeEname;
    }

    /**
     * @return TRANS_TYPE_CODE
     */
    public String getTransTypeCode() {
        return transTypeCode;
    }

    /**
     * @param transTypeCode
     */
    public void setTransTypeCode(String transTypeCode) {
        this.transTypeCode = transTypeCode;
    }

    /**
     * @return TRANS_TYPE_NAME
     */
    public String getTransTypeName() {
        return transTypeName;
    }

    /**
     * @param transTypeName
     */
    public void setTransTypeName(String transTypeName) {
        this.transTypeName = transTypeName;
    }

    /**
     * @return GOODS_PLACE
     */
    public String getGoodsPlace() {
        return goodsPlace;
    }

    /**
     * @param goodsPlace
     */
    public void setGoodsPlace(String goodsPlace) {
        this.goodsPlace = goodsPlace;
    }

    /**
     * @return TRADE_MODE_CODE
     */
    public String getTradeModeCode() {
        return tradeModeCode;
    }

    /**
     * @param tradeModeCode
     */
    public void setTradeModeCode(String tradeModeCode) {
        this.tradeModeCode = tradeModeCode;
    }

    /**
     * @return TRADE_MODE_NAME
     */
    public String getTradeModeName() {
        return tradeModeName;
    }

    /**
     * @param tradeModeName
     */
    public void setTradeModeName(String tradeModeName) {
        this.tradeModeName = tradeModeName;
    }

    /**
     * @return DESP_PORT_CODE
     */
    public String getDespPortCode() {
        return despPortCode;
    }

    /**
     * @param despPortCode
     */
    public void setDespPortCode(String despPortCode) {
        this.despPortCode = despPortCode;
    }

    /**
     * @return DESP_PORT_NAME
     */
    public String getDespPortName() {
        return despPortName;
    }

    /**
     * @param despPortName
     */
    public void setDespPortName(String despPortName) {
        this.despPortName = despPortName;
    }

    /**
     * @return ARRI_PORT_CODE
     */
    public String getArriPortCode() {
        return arriPortCode;
    }

    /**
     * @param arriPortCode
     */
    public void setArriPortCode(String arriPortCode) {
        this.arriPortCode = arriPortCode;
    }

    /**
     * @return ARRI_PORT_NAME
     */
    public String getArriPortName() {
        return arriPortName;
    }

    /**
     * @param arriPortName
     */
    public void setArriPortName(String arriPortName) {
        this.arriPortName = arriPortName;
    }

    /**
     * @return ENTRY_PORT_CODE
     */
    public String getEntryPortCode() {
        return entryPortCode;
    }

    /**
     * @param entryPortCode
     */
    public void setEntryPortCode(String entryPortCode) {
        this.entryPortCode = entryPortCode;
    }

    /**
     * @return ENTRY_PORT_NAME
     */
    public String getEntryPortName() {
        return entryPortName;
    }

    /**
     * @param entryPortName
     */
    public void setEntryPortName(String entryPortName) {
        this.entryPortName = entryPortName;
    }

    /**
     * @return DEST_CODE
     */
    public String getDestCode() {
        return destCode;
    }

    /**
     * @param destCode
     */
    public void setDestCode(String destCode) {
        this.destCode = destCode;
    }

    /**
     * @return DEST_NAME
     */
    public String getDestName() {
        return destName;
    }

    /**
     * @param destName
     */
    public void setDestName(String destName) {
        this.destName = destName;
    }

    /**
     * @return TRADE_COUNTRY_CODE
     */
    public String getTradeCountryCode() {
        return tradeCountryCode;
    }

    /**
     * @param tradeCountryCode
     */
    public void setTradeCountryCode(String tradeCountryCode) {
        this.tradeCountryCode = tradeCountryCode;
    }

    /**
     * @return TRADE_COUNTRY_NAME
     */
    public String getTradeCountryName() {
        return tradeCountryName;
    }

    /**
     * @param tradeCountryName
     */
    public void setTradeCountryName(String tradeCountryName) {
        this.tradeCountryName = tradeCountryName;
    }

    /**
     * @return DESP_COUNTRY_CODE
     */
    public String getDespCountryCode() {
        return despCountryCode;
    }

    /**
     * @param despCountryCode
     */
    public void setDespCountryCode(String despCountryCode) {
        this.despCountryCode = despCountryCode;
    }

    /**
     * @return DESP_COUNTRY_NAME
     */
    public String getDespCountryName() {
        return despCountryName;
    }

    /**
     * @param despCountryName
     */
    public void setDespCountryName(String despCountryName) {
        this.despCountryName = despCountryName;
    }

    /**
     * @return CONTRACT_NO
     */
    public String getContractNo() {
        return contractNo;
    }

    /**
     * @param contractNo
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    /**
     * @return PROD_REG_NO
     */
    public String getProdRegNo() {
        return prodRegNo;
    }

    /**
     * @param prodRegNo
     */
    public void setProdRegNo(String prodRegNo) {
        this.prodRegNo = prodRegNo;
    }

    /**
     * @return PROD_CNAME
     */
    public String getProdCname() {
        return prodCname;
    }

    /**
     * @param prodCname
     */
    public void setProdCname(String prodCname) {
        this.prodCname = prodCname;
    }

    /**
     * @return PROD_CONTACT
     */
    public String getProdContact() {
        return prodContact;
    }

    /**
     * @param prodContact
     */
    public void setProdContact(String prodContact) {
        this.prodContact = prodContact;
    }

    /**
     * @return PROD_TEL
     */
    public String getProdTel() {
        return prodTel;
    }

    /**
     * @param prodTel
     */
    public void setProdTel(String prodTel) {
        this.prodTel = prodTel;
    }

    /**
     * @return HS_CODE
     */
    public String getHsCode() {
        return hsCode;
    }

    /**
     * @param hsCode
     */
    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    /**
     * @return GOODS_CNAME
     */
    public String getGoodsCname() {
        return goodsCname;
    }

    /**
     * @param goodsCname
     */
    public void setGoodsCname(String goodsCname) {
        this.goodsCname = goodsCname;
    }

    /**
     * @return GOODS_ENAME
     */
    public String getGoodsEname() {
        return goodsEname;
    }

    /**
     * @param goodsEname
     */
    public void setGoodsEname(String goodsEname) {
        this.goodsEname = goodsEname;
    }

    /**
     * @return GOODS_MODEL
     */
    public String getGoodsModel() {
        return goodsModel;
    }

    /**
     * @param goodsModel
     */
    public void setGoodsModel(String goodsModel) {
        this.goodsModel = goodsModel;
    }

    /**
     * @return ORIGIN_PLACE_CODE
     */
    public String getOriginPlaceCode() {
        return originPlaceCode;
    }

    /**
     * @param originPlaceCode
     */
    public void setOriginPlaceCode(String originPlaceCode) {
        this.originPlaceCode = originPlaceCode;
    }

    /**
     * @return ORIGIN_PLACE_NAME
     */
    public String getOriginPlaceName() {
        return originPlaceName;
    }

    /**
     * @param originPlaceName
     */
    public void setOriginPlaceName(String originPlaceName) {
        this.originPlaceName = originPlaceName;
    }

    /**
     * @return ORIGIN_COUNTRY_CODE
     */
    public String getOriginCountryCode() {
        return originCountryCode;
    }

    /**
     * @param originCountryCode
     */
    public void setOriginCountryCode(String originCountryCode) {
        this.originCountryCode = originCountryCode;
    }

    /**
     * @return ORIGIN_COUNTRY_NAME
     */
    public String getOriginCountryName() {
        return originCountryName;
    }

    /**
     * @param originCountryName
     */
    public void setOriginCountryName(String originCountryName) {
        this.originCountryName = originCountryName;
    }

    /**
     * @return QTY
     */
    public BigDecimal getQty() {
        return qty;
    }

    /**
     * @param qty
     */
    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    /**
     * @return QTY_UNIT_CODE
     */
    public String getQtyUnitCode() {
        return qtyUnitCode;
    }

    /**
     * @param qtyUnitCode
     */
    public void setQtyUnitCode(String qtyUnitCode) {
        this.qtyUnitCode = qtyUnitCode;
    }

    /**
     * @return QTY_UNIT_NAME
     */
    public String getQtyUnitName() {
        return qtyUnitName;
    }

    /**
     * @param qtyUnitName
     */
    public void setQtyUnitName(String qtyUnitName) {
        this.qtyUnitName = qtyUnitName;
    }

    /**
     * @return WEIGHT
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * @return WEIGHT_UNIT_CODE
     */
    public String getWeightUnitCode() {
        return weightUnitCode;
    }

    /**
     * @param weightUnitCode
     */
    public void setWeightUnitCode(String weightUnitCode) {
        this.weightUnitCode = weightUnitCode;
    }

    /**
     * @return WEIGHT_UNIT_NAME
     */
    public String getWeightUnitName() {
        return weightUnitName;
    }

    /**
     * @param weightUnitName
     */
    public void setWeightUnitName(String weightUnitName) {
        this.weightUnitName = weightUnitName;
    }

    /**
     * @return GOODS_UNIT_PRICE
     */
    public BigDecimal getGoodsUnitPrice() {
        return goodsUnitPrice;
    }

    /**
     * @param goodsUnitPrice
     */
    public void setGoodsUnitPrice(BigDecimal goodsUnitPrice) {
        this.goodsUnitPrice = goodsUnitPrice;
    }

    /**
     * @return GOODS_TOTAL_VALUES
     */
    public BigDecimal getGoodsTotalValues() {
        return goodsTotalValues;
    }

    /**
     * @param goodsTotalValues
     */
    public void setGoodsTotalValues(BigDecimal goodsTotalValues) {
        this.goodsTotalValues = goodsTotalValues;
    }

    /**
     * @return CURR_UNIT
     */
    public String getCurrUnit() {
        return currUnit;
    }

    /**
     * @param currUnit
     */
    public void setCurrUnit(String currUnit) {
        this.currUnit = currUnit;
    }

    /**
     * @return CURR_UNIT_NAME
     */
    public String getCurrUnitName() {
        return currUnitName;
    }

    /**
     * @param currUnitName
     */
    public void setCurrUnitName(String currUnitName) {
        this.currUnitName = currUnitName;
    }

    /**
     * @return PACK_NUMBER
     */
    public BigDecimal getPackNumber() {
        return packNumber;
    }

    /**
     * @param packNumber
     */
    public void setPackNumber(BigDecimal packNumber) {
        this.packNumber = packNumber;
    }

    /**
     * @return PACK_TYPE_CODE
     */
    public String getPackTypeCode() {
        return packTypeCode;
    }

    /**
     * @param packTypeCode
     */
    public void setPackTypeCode(String packTypeCode) {
        this.packTypeCode = packTypeCode;
    }

    /**
     * @return PACK_TYPE_NAME
     */
    public String getPackTypeName() {
        return packTypeName;
    }

    /**
     * @param packTypeName
     */
    public void setPackTypeName(String packTypeName) {
        this.packTypeName = packTypeName;
    }

    /**
     * @return STD_QUANTITY
     */
    public BigDecimal getStdQuantity() {
        return stdQuantity;
    }

    /**
     * @param stdQuantity
     */
    public void setStdQuantity(BigDecimal stdQuantity) {
        this.stdQuantity = stdQuantity;
    }

    /**
     * @return STD_UNIT_CODE
     */
    public String getStdUnitCode() {
        return stdUnitCode;
    }

    /**
     * @param stdUnitCode
     */
    public void setStdUnitCode(String stdUnitCode) {
        this.stdUnitCode = stdUnitCode;
    }

    /**
     * @return STD_UNIT_NAME
     */
    public String getStdUnitName() {
        return stdUnitName;
    }

    /**
     * @param stdUnitName
     */
    public void setStdUnitName(String stdUnitName) {
        this.stdUnitName = stdUnitName;
    }
}