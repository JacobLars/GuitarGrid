import React, { useState } from "react";
type Props = {
  setOption: Function;
};
export const SortByPrice = ({ setOption }: Props) => {
  const handleOptionChange = (event: any) => {
    setOption(event.target.value);
  };

  return (
    <div className="flex p-5">
      <select
        className="mx-auto shadow-md border border-slate-600 md:justify-center"
        onChange={(e) => handleOptionChange(e)}
      >
        <option>Sort by price</option>
        <option>Highest to lowest</option>
        <option>Lowest to highest </option>
      </select>
    </div>
  );
};
