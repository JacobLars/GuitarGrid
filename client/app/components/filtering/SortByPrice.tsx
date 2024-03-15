import React, { useState } from "react";
type Props = {
  setOption: Function;
};
export const SortByPrice = ({ setOption }: Props) => {
  const handleOptionChange = (event: any) => {
    setOption(event.target.value);
  };

  return (
    <div>
      <select onChange={(e) => handleOptionChange(e)}>
        <option>Highest to lowest</option>
        <option>Lowest to highest </option>
      </select>
    </div>
  );
};
