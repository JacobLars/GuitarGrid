import React, { useEffect } from "react";

type Props = {
  productId: string;
};

export const ProductPage = ({ productId }: Props) => {
  useEffect(() => {}, []);

  return (
    <div>
      <h1>Hello!</h1>
    </div>
  );
};
