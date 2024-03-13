"use client";

import { BrandProductsGallery } from "@/app/components/products/productsByBrand/BrandProductsGallery";

export default function BrandProducts({
  params,
}: {
  params: { brandId: string };
}) {
  return (
    <div className="">
      <BrandProductsGallery brandId={params.brandId} />
    </div>
  );
}
