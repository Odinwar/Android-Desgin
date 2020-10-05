package com.example.myapplication

import android.annotation.SuppressLint
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment
import com.google.android.material.shape.ShapePath

class BottomAppBarCutCornersTopEdge(
    var fabCradleMargin: Float,
    fabCradleRoundedCornerRadius: Float,
    var cradleVerticalOffset: Float
) :
    BottomAppBarTopEdgeTreatment(
        fabCradleMargin,
        fabCradleRoundedCornerRadius,
        cradleVerticalOffset
    ) {
    @SuppressLint("RestrictedApi")
    @Override
    @SuppressWarnings("RestrictTo")
    override fun getEdgePath(
        length: Float,
        center: Float,
        interpolation: Float,
        shapePath: ShapePath
    ) {
        var fabDiameter = super.getFabDiameter();
        if (fabDiameter == 0.toFloat()) {
            shapePath.lineTo(length, 0F);
            return;
        }

        var diamondSize = fabDiameter / 2f;
        var middle = center + getHorizontalOffset();

        var verticalOffsetRatio = cradleVerticalOffset / diamondSize;
        if (verticalOffsetRatio >= 1.0f) {
            shapePath.lineTo(length, 0F);
            return;
        }

        shapePath.lineTo(middle - (fabCradleMargin + diamondSize - cradleVerticalOffset), 0F);

        shapePath.lineTo(
            middle,
            (diamondSize - cradleVerticalOffset + fabCradleMargin) * interpolation
        );

        shapePath.lineTo(middle + (fabCradleMargin + diamondSize - cradleVerticalOffset), 0F);

        shapePath.lineTo(length, 0F);
    }
}
