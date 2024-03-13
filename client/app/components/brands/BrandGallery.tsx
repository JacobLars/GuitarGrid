import { Brand } from "@/app/types/Types";
import React, { useEffect, useState } from "react";

export const BrandGallery = () => {
  const [brands, setBrands] = useState<Brand[]>([]);
  useEffect(() => {
    const fetchAllBrands = async () => {
      const response = await fetch("http://localhost:8080/api/v1/brands");
      const responseToJson = await response.json();
      setBrands(responseToJson.brands);
    };
    fetchAllBrands();
  }, []);

  return (
    <div>
      <h2></h2>
    </div>
  );
};
