package com.oraen.oxygen.excelutil.component.workbook.node;

import com.oraen.oxygen.excelutil.component.HasPoint;
import com.oraen.oxygen.excelutil.component.Point;
import com.oraen.oxygen.excelutil.component.WbNode;

public abstract class ExplicitWbNode extends WbNode implements HasPoint {
    protected Point point;

    public ExplicitWbNode(){
        point = new Point();
    }

    @Override
    public Point getPoint() {
        return point;
    }

    @Override
    public void setPoint(Point point) {
        this.point = point;

    }
}
